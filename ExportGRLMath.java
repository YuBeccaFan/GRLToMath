package seg.jUCMNav.importexport;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import grl.Actor;
import grl.ActorRef;
import grl.Belief;
import grl.Contribution;
import grl.Decomposition;
import grl.Dependency;
import grl.ElementLink;
import grl.IntentionalElement;
import java.io.FileOutputStream;
import grl.IntentionalElementRef;
import grl.kpimodel.Indicator;
import grl.kpimodel.KPIModelLink;
import seg.jUCMNav.extensionpoints.IURNExport;
import seg.jUCMNav.importexport.utils.EscapeUtils;
import urn.URNspec;
import urncore.IURNNode;

/**
 * this class export the URN model into sympy function
 * 
 * @author Yuxuan Fan
 *
 */
public class ExportGRLMath implements IURNExport {

    private FileOutputStream fos;
    private String filename;
    public static final String LeftBracker = "(";
    public static final String RightBracker = ")";
    public static final String Comma = ",";
    public static final String Equal = "=";
    public static final String Sym = "symbols";
    public static final String Times = "*";
    public static final String Divide = "/";
    public static final String Plus = "+";
    public static final String Minus = "-";

    private Map<IntentionalElement, StringBuffer> eleForMap;// store elements and the functions .

    private Map<Actor, StringBuffer> actorForMap;
    private StringBuffer modelFormula;
    private HashSet<String> elementSet = new HashSet<String>();

    @Override
    public void export(URNspec urn, HashMap mapDiagrams, FileOutputStream fos) throws InvocationTargetException {
	// TODO Auto-generated method stub
	// not used
    }

    @Override
    public void export(URNspec urn, HashMap mapDiagrams, String filename) throws InvocationTargetException {

	try {
	    fos = new FileOutputStream(filename);
	    // to run the functions
	    writeHead();
	    writeFormula(urn);
	    writeActor(urn);
	    // writeIndicator(urn);
	    writeModel(urn);
	    writeTranslation(urn);
	} catch (Exception e) {
	    throw new InvocationTargetException(e);
	} finally {
	    // close the stream
	    if (fos != null) {
		try {
		    fos.close();
		} catch (IOException e1) {
		    e1.printStackTrace();
		}
	    }
	}
    }

    /**
     * Write the string to the file output stream.
     * 
     * @param s
     *            the string to write
     * @throws IOException
     */
    public void write(String s) throws IOException {
	if (s != null && s.length() > 0) {
	    fos.write(s.getBytes());
	}
    }

    private void writeHead() throws IOException {

	write("from MathTo import * \n" + "from sympy import *\n");
	write("import sys");
	write("\n");
	write("\n");
    }

    /**
     * create formulas for each elements
     * 
     * @param urn
     * @throws IOException
     */
    private void writeFormula(URNspec urn) throws IOException {

	eleForMap = new HashMap<IntentionalElement, StringBuffer>();
	StringBuffer eleFormula;
	StringBuffer function;
	// initial all the symbols
	for (Iterator it = urn.getGrlspec().getIntElements().iterator(); it.hasNext();) {
	    IntentionalElement element = (IntentionalElement) it.next();
	    StringBuffer variable = new StringBuffer();
	    variable.append(modifyName(element.getName()));
	    variable.append(Equal);
	    variable.append("Symbol");
	    variable.append(LeftBracker);
	    variable.append("'");
	    variable.append(modifyName(element.getName()));
	    variable.append("'");
	    variable.append(RightBracker);
	    write(variable.toString());
	    write("\n");
	}
	write("\n");
	// iterate all the leaf element
	for (Iterator it = urn.getGrlspec().getIntElements().iterator(); it.hasNext();) {
	    IntentionalElement element = (IntentionalElement) it.next();
	    eleFormula = new StringBuffer();
	    function = new StringBuffer();
	    function.append(modifyName(element.getName()));
	    // if the element is the leaf
	    if (element.getLinksDest().size() == 0) {
		// System.out.println(element.getName() + "leaf");
		if (element.getType().getName().compareTo("Indicator") == 0) {
		    Indicator indicator = (Indicator) element;
		    if (indicator.getWorstValue() == indicator.getTargetValue()) {
			eleFormula.append(modifyName(element.getName()));
		    } else {
			StringBuffer indicatorFor = indicatorFor(element);
			eleFormula.append(indicatorFor);
			function.append(Equal);
			function.append(eleFormula);
		    }
		} else {
		    eleFormula.append(modifyName(element.getName()));
		}
		elementSet.add("'" + modifyName(element.getName()) + "'");
		eleForMap.put(element, eleFormula);
		System.out.println("ele's for" + element.getName() + ":" + eleFormula);
	    }
	}
	for (Iterator it = urn.getGrlspec().getIntElements().iterator(); it.hasNext();) {
	    IntentionalElement element = (IntentionalElement) it.next();
	    eleFormula = new StringBuffer();
	    function = new StringBuffer();
	    function.append(modifyName(element.getName()));

	    if (element.getLinksDest().size() != 0) {
		eleFormula.append(writeLink(element));
		System.out.println("ele's for" + element.getName() + ":" + eleFormula);
		function.append(Equal);
		function.append(eleFormula);
		System.out.println(element.getName() + function);
		write(function.toString());
		write("\n");
		eleForMap.put(element, eleFormula);
	    }
	}
	write("\n");
    }

    /**
     * 
     * @param element
     * @return
     * @throws IOException
     */
    private StringBuffer writeLink(IntentionalElement element) throws IOException {

	StringBuffer formula = new StringBuffer();
	StringBuffer decomFor = new StringBuffer();
	StringBuffer conFor = new StringBuffer();
	StringBuffer depenFor = new StringBuffer();
	List<String> StrEle = new ArrayList<String>();// the elements' str

	Map<String, List<IntentionalElement>> eleMap = new HashMap<String, List<IntentionalElement>>();
	List<IntentionalElement> decomList = new ArrayList<IntentionalElement>();
	List<IntentionalElement> depenList = new ArrayList<IntentionalElement>();
	List<IntentionalElement> conList = new ArrayList<IntentionalElement>();
	List<ElementLink> conLink = new ArrayList<ElementLink>();
	List<IntentionalElement> srcList = new ArrayList<IntentionalElement>();

	for (Iterator it = element.getLinksDest().iterator(); it.hasNext();) {
	    ElementLink scrLink = (ElementLink) it.next();
	    IntentionalElement srcElement = (IntentionalElement) (scrLink.getSrc());
	    srcList.add(srcElement);
	    StrEle.add(modifyName(srcElement.getName()));

	    if (scrLink instanceof Decomposition) {
		decomList.add(srcElement);
	    }
	    if (scrLink instanceof Dependency) {
		depenList.add(srcElement);
		elementSet.add("'" + modifyName(srcElement.getName()) + "'");
	    }
	    if (scrLink instanceof Contribution) {
		conList.add(srcElement);
		conLink.add(scrLink);
	    }
	    eleMap.put("Decomposition", decomList);
	    eleMap.put("Dependency", depenList);
	    eleMap.put("Contribution", conList);
	} // for
	  // first decomposition; second contribution; third dependency
	String funcTpye = " ";
	if (!decomList.isEmpty()) {
	    if (element.getDecompositionType().getName() == "And")
		funcTpye = "Min";
	    if (element.getDecompositionType().getName() == "Or")
		funcTpye = "Max";
	    if (element.getDecompositionType().getName() == "Xor")
		funcTpye = "Max";

	    decomFor.append(writeDecomMaxMin(decomList, funcTpye));
	    formula = decomFor;
	}

	if (!conList.isEmpty()) {
	    conFor.append("Max");
	    conFor.append(LeftBracker);
	    conFor.append("0.0");
	    conFor.append(Comma);
	    conFor.append("Min");
	    conFor.append(LeftBracker);
	    conFor.append("100.0");
	    conFor.append(Comma);
	    conFor.append(LeftBracker);
	    List<String> conTimesList = new ArrayList<String>();
	    for (int i = 0; i < conLink.size(); i++) {
		System.out.println("contributuin ele:" + conList.get(i).getName());
		String conTimes = new String();
		conTimes = Integer.toString(((Contribution) conLink.get(i)).getQuantitativeContribution()) + Times
			+ modifyName(conList.get(i).getName());
		conTimesList.add(conTimes);
	    }
	    if (!decomList.isEmpty()) {
		conTimesList.add(decomFor + Times + "100.0");
	    }

	    String joined = String.join("+", conTimesList);
	    conFor.append(joined);
	    conFor.append(RightBracker);
	    conFor.append(Divide);
	    conFor.append("100.0");
	    conFor.append(RightBracker);
	    conFor.append(RightBracker);

	    formula = conFor;
	}
	if (!depenList.isEmpty()) {
	    depenFor.append(writeDepenMaxMin(depenList, formula, element));
	    formula = depenFor;
	}
	System.out.println(formula);
//	if (element.getType().getName().compareTo("Indicator") == 0) {
//	    System.out.println("indicator!" + element.getName() + "\n");
//
//	    StringBuffer indicatorFor = indicatorFor(element);
//	    System.out.println(indicatorFor.toString());
//	    
//	    formula = new StringBuffer(
//		    indicatorFor.toString().replaceAll(modifyName(element.getName()), formula.toString()));
//	    System.out.println(formula);
//	}
	for (Iterator it = srcList.iterator(); it.hasNext();) {
	    IntentionalElement subEle = (IntentionalElement) it.next();
	    // if sub element is not the leaf.
	    StringBuffer subFor = new StringBuffer();
	    if (subEle.getLinksDest().size() != 0) {
		if (eleForMap.get(subEle) == null) {
		    subFor = writeLink(subEle);
		} else {
		    System.out.println("you have subfor!");
		    subFor = eleForMap.get(subEle);
		}
		formula = new StringBuffer(
			formula.toString().replaceAll(modifyName(subEle.getName()), subFor.toString()));
	    }
	    // if the element is indicator
	    if (subEle.getType().getName().compareTo("Indicator") == 0) {
		StringBuffer indicatorFor = new StringBuffer();
		if (eleForMap.get(subEle) == null) {
		    indicatorFor = indicatorFor(subEle);
		} else {
		    indicatorFor = eleForMap.get(subEle);
		    formula = new StringBuffer(
			    formula.toString().replaceAll(modifyName(subEle.getName()), indicatorFor.toString()));
		}
	    }
	}
	return formula;

    }

    private StringBuffer MaxmaxFormat(Stack<StringBuffer> subst, String func) throws IOException {
	Stack<StringBuffer> stMax = new Stack<StringBuffer>();
	int stSize = subst.size();
	if (stSize == 1) {
	    StringBuffer result = new StringBuffer(subst.pop());
	    return result;
	}
	for (int i = 1; i < stSize; i += 2) {
	    StringBuffer subfor = new StringBuffer();
	    subfor.append(func);
	    subfor.append(LeftBracker);
	    subfor.append(subst.pop().toString());
	    subfor.append(Comma);
	    subfor.append(subst.pop().toString());
	    subfor.append(RightBracker);
	    stMax.push(subfor);
	}
	if (stSize % 2 == 1) {
	    stMax.push(subst.pop());
	}
	return MaxmaxFormat(stMax, func);
    }

    private StringBuffer writeDecomMaxMin(List<IntentionalElement> list, String func) throws IOException {
	StringBuffer formula = new StringBuffer();
	Stack<StringBuffer> st = new Stack<StringBuffer>();
	if (list.size() == 1) {
	    formula.append(modifyName(list.get(0).getName()));
	} else if (list.size() == 2) {
	    formula.append(func);
	    formula.append(LeftBracker);
	    formula.append(modifyName(modifyName(list.get(0).getName())));
	    formula.append(Comma);
	    formula.append(modifyName(modifyName(list.get(1).getName())));
	    formula.append(RightBracker);
	} else if (list.size() > 2) {

	    for (int i = 0; i < list.size(); i++) {
		StringBuffer subfo = new StringBuffer(modifyName(list.get(i).getName()));
		st.add(subfo);
	    }
	    formula.append(MaxmaxFormat(st, func));
	}
	// write(formula.toString());
	return formula;

    }

    private StringBuffer writeDepenMaxMin(List<IntentionalElement> list, StringBuffer func, IntentionalElement element)
	    throws IOException {

	StringBuffer formula = new StringBuffer();
	Stack<StringBuffer> st = new Stack<StringBuffer>();
	if (func.length() == 0) {
	    StringBuffer eleSt = new StringBuffer(modifyName(element.getName()));
	    st.add(eleSt);
	} else {
	    st.add(func);
	}

	for (int i = 0; i < list.size(); i++) {
	    StringBuffer subfo = new StringBuffer(modifyName(list.get(i).getName()));
	    st.add(subfo);
	}
	formula.append(MaxmaxFormat(st, "Min"));
	return formula;
    }

    /**
     * If none of the top-level intentional elements has a weight, then these
     * top-level intentional elements should be weighted equally. we assume only the
     * top-level elements have weight
     * 
     * @param urn
     * @throws IOException
     */

    private void writeActor(URNspec urn) throws IOException {
	actorForMap = new HashMap<Actor, StringBuffer>();
	StringBuffer formula;
	StringBuffer function;// 还要判断一下 里面有没有东西
	for (Iterator it = urn.getGrlspec().getActors().iterator(); it.hasNext();) {
	    Actor actor = (Actor) it.next();
	    function = new StringBuffer();
	    function.append(modifyName(actor.getName()));
	    formula = new StringBuffer();// the part after =
	    // System.out.println(actor.getName());
	    int sumQua = 0;
	    int dNum = 100;
	    boolean hasEleInActor = true;
	    List<IntentionalElement> eleList = new ArrayList<IntentionalElement>();// the elements in the actor
	    List<Integer> quaList = new ArrayList<Integer>();
	    List<String> actorTimesQua = new ArrayList<String>();
	    // Iterator itAct = actor.getContRefs().iterator();
	    for (Iterator itAct = actor.getContRefs().iterator(); itAct.hasNext();) {
		ActorRef actorRef = (ActorRef) itAct.next();
		Iterator itIEref = actorRef.getNodes().iterator();
		// System.out.println("Come to "+actor.getName());
		if (!itIEref.hasNext()) {
		    hasEleInActor = false;
		} else {
		    hasEleInActor = true;
		    for (; itIEref.hasNext();) {
			IURNNode node = (IURNNode) itIEref.next();
			// System.out.println("juziqian");
			if (node instanceof Belief) {

			    // Belief be = (Belief)node;
			    // System.out.println("BElief!");
			    continue;
			}

			IntentionalElement ele = (IntentionalElement) ((IntentionalElementRef) node).getDef();
			eleList.add(ele);
			// System.out.println("elements in the Actor" + actor.getName() + ":" +
			// ele.getName());
			int eleQua = ele.getImportanceQuantitative();
			quaList.add(eleQua);
			sumQua += eleQua;
		    }
		}
	    }

	    if (sumQua == 0 && hasEleInActor == true) {// there are no weighted elements in actor
		System.out.println("sum == 0 ");
		for (int i = 0; i < eleList.size(); i++) {
		    IntentionalElement ele = (IntentionalElement) (eleList.get(i));
		    StringBuffer eleFormula = new StringBuffer();
		    eleFormula.append(LeftBracker);
		    eleFormula.append(eleForMap.get(ele));
		    // eleFormula.append(writeLink(ele)[1]);
		    eleFormula.append(RightBracker);
		    if (ele.getLinksSrc().size() == 0) {
			// actorTimesQua.add(ele.getName() + Times + "100");
			actorTimesQua.add(eleFormula + Times + "100.0");
			sumQua += 100;
		    } else {
			// give the weight to top-level elements;
			IntentionalElement srcElement = (IntentionalElement) (((ElementLink) (ele.getLinksSrc().get(0)))
				.getDest());

			System.out.println(srcElement.getName());
			if (eleList.contains(srcElement) == false) {
			    // actorTimesQua.add(ele.getName() + Times + "100");
			    actorTimesQua.add(eleFormula + Times + "100.0");
			    sumQua += 100;
			}
		    }
		} // for
	    } // if(sumQua==0)
	    if (sumQua > 0) {// there are some elements weighted
		System.out.println("sum! = 0 ");
		for (int i = 0; i < eleList.size(); i++) {
		    IntentionalElement ele = (IntentionalElement) (eleList.get(i));
		    if (ele.getImportanceQuantitative() == 0) {
			continue;
		    }
		    // actorTimesQua.add(ele.getName() + Times + ele.getImportanceQuantitative());
		    actorTimesQua.add(eleForMap.get(ele) + Times + "100.0");
		}
	    }
	    // }
	    // System.out.println(actorTimesQua);
	    if (!hasEleInActor)
		formula.append("0");
	    else {
		formula.append(LeftBracker);
		String joined = String.join("+", actorTimesQua);
		formula.append(joined);
		formula.append(RightBracker);
		formula.append(Divide);
		formula.append(Integer.toString(Math.max(sumQua, dNum)));
	    }
	    function.append(Equal);
	    function.append(formula);
	    write(function.toString());
	    write("\n");
	    actorForMap.put(actor, formula);

	}
    }

    /**
     * If there is no actor in the model, then it would be as if there were one big
     * actor with weight 100 that contained everything.
     * 
     * If there are actors but they have no weight, then these actors should be
     * weighted equally.
     * 
     * @param urn
     * @throws IOException
     */
    private void writeModel(URNspec urn) throws IOException {
	modelFormula = new StringBuffer();
	StringBuffer function = new StringBuffer();
	List<Actor> actorList = new ArrayList<Actor>();
	List<Actor> actHasWeight = new ArrayList<Actor>();
	List<String> actorTimesWeight = new ArrayList<String>();

	int sumQua = 0;
	int dNum = 100;
	function.append(urn.getName());
	function.append(Equal);
	for (Iterator it = urn.getGrlspec().getActors().iterator(); it.hasNext();) {
	    Actor actor = (Actor) it.next();
	    actorList.add(actor);
	    if (actor.getImportanceQuantitative() != 0) {
		actHasWeight.add(actor);
	    }

	} // for
	if (actorList.size() == 0) {
	    // it's like there is one big actor weighted 100 containing anything
	    modelFormula = ModelWithoutActor(urn);
	} else {
	    if (actHasWeight.size() == 0) {

		for (int i = 0; i < actorList.size(); i++) {
		    StringBuffer actorRe = new StringBuffer();
		    actorRe.append(LeftBracker);
		    actorRe.append(actorForMap.get(actorList.get(i)));
		    actorRe.append(RightBracker);
		    actorTimesWeight.add(actorRe + Times + "100.0");
		}
		sumQua = 100 * actorList.size();
	    } else {
		for (int i = 0; i < actorList.size(); i++) {
		    int actorQua = actorList.get(i).getImportanceQuantitative();
		    StringBuffer actorRe = new StringBuffer();
		    actorRe.append(LeftBracker);
		    actorRe.append(actorForMap.get(actorList.get(i)));
		    actorRe.append(RightBracker);
		    actorTimesWeight.add(actorForMap.get(actorList.get(i)) + Times + actorQua);
		    sumQua += actorQua;
		}
	    }
	    String joined = String.join("+", actorTimesWeight);
	    modelFormula.append(LeftBracker);
	    modelFormula.append(joined);
	    modelFormula.append(RightBracker);
	    modelFormula.append(Divide);
	    modelFormula.append(Integer.toString(Math.max(sumQua, dNum)));
	}
	function.append(modelFormula);
	write(function.toString());
	write("\n");
    }

    private StringBuffer ModelWithoutActor(URNspec urn) throws IOException {
	List<IntentionalElement> eleList = new ArrayList<IntentionalElement>();// the elements in the actor
	StringBuffer formula = new StringBuffer();
	List<Integer> quaList = new ArrayList<Integer>();
	List<String> actorTimesQua = new ArrayList<String>();
	int sumQua = 0;
	int dNum = 100;
	for (Iterator it = urn.getGrlspec().getIntElements().iterator(); it.hasNext();) {
	    IntentionalElement ele = (IntentionalElement) it.next();
	    eleList.add(ele);
	    int eleQua = ele.getImportanceQuantitative();
	    quaList.add(eleQua);
	    sumQua += eleQua;

	}

	if (eleList.size() == 0) {
	    // actorFormula.append("0");

	} else {// there are elements in the actor
	    if (sumQua == 0) {// there are no weighted elements in actor
		System.out.println("sum == 0 ");
		for (int i = 0; i < eleList.size(); i++) {
		    IntentionalElement ele = (IntentionalElement) (eleList.get(i));
		    StringBuffer eleFormula = new StringBuffer();
		    eleFormula.append(LeftBracker);
		    eleFormula.append(eleForMap.get(ele));
		    eleFormula.append(RightBracker);
		    if (ele.getLinksSrc().size() == 0) {
			// actorTimesQua.add(ele.getName() + Times + "100");
			actorTimesQua.add(eleFormula + Times + "100.0");
			sumQua += 100;
		    } else {
			// give the weight to top-level elements;
			IntentionalElement srcElement = (IntentionalElement) (((ElementLink) (ele.getLinksSrc().get(0)))
				.getDest());

			System.out.println(srcElement.getName());
			if (eleList.contains(srcElement) == false) {
			    // actorTimesQua.add(ele.getName() + Times + "100");
			    actorTimesQua.add(eleFormula + Times + "100.0");
			    sumQua += 100;
			}
		    }
		} // for
	    } // if(sumQua==0)
	    else {// there are some elements weighted
		System.out.println("sum! = 0 ");
		for (int i = 0; i < eleList.size(); i++) {
		    IntentionalElement ele = (IntentionalElement) (eleList.get(i));
		    if (ele.getImportanceQuantitative() == 0) {
			continue;
		    }
		    actorTimesQua.add(eleForMap.get(ele) + Times + "100.0");
		}
	    }
	}
	formula.append(LeftBracker);
	String joined = String.join("+", actorTimesQua);
	formula.append(joined);
	formula.append(RightBracker);
	formula.append(Divide);
	formula.append(Integer.toString(Math.max(sumQua, dNum)));
	return formula;

    }

    private StringBuffer indicatorFor(IntentionalElement intElement) throws IOException {
	StringBuffer formula = new StringBuffer();
	Indicator indicator = (Indicator) intElement;
	String currentName = new String(modifyName(indicator.getName()));
	double worst = indicator.getWorstValue();
	double target = indicator.getTargetValue();
	double threshold = indicator.getThresholdValue();
	formula = new StringBuffer();
	formula.append("Piecewise");
	formula.append(LeftBracker);
	if ((worst == threshold) && (threshold == target)) {// warning
	    System.out.println("Warning: the three value should not be equal");
	}
	if (worst < target) {
	    formula.append(LeftBracker);
	    formula.append("100");
	    formula.append(Comma);
	    formula.append(currentName);
	    formula.append(">=");
	    formula.append(Double.toString(target));
	    formula.append(RightBracker);
	    formula.append(Comma);

	    formula.append(LeftBracker);//
	    formula.append("abs( ");
	    formula.append(LeftBracker);// (x-th)
	    formula.append(currentName);
	    formula.append(Minus);
	    formula.append(Double.toString(threshold));
	    formula.append(RightBracker);
	    formula.append(Divide);
	    double diNum = (target - threshold) * 200;
	    formula.append(Double.toString(diNum));
	    formula.append(RightBracker);
	    formula.append(Plus);
	    formula.append("50");
	    formula.append(Comma);

	    formula.append("(");
	    formula.append(Double.toString(threshold));
	    formula.append("<");
	    formula.append(currentName);
	    formula.append(")");
	    formula.append("&");
	    formula.append("(");
	    formula.append(currentName);
	    formula.append("<");
	    formula.append(Double.toString(target));
	    formula.append(")");
	    formula.append(RightBracker);
	    formula.append(Comma);

	    formula.append(LeftBracker);
	    formula.append("-abs( ");
	    formula.append(LeftBracker);
	    formula.append(currentName);
	    formula.append(Minus);
	    formula.append(Double.toString(threshold));
	    formula.append(RightBracker);
	    formula.append(Divide);
	    double diNum2 = (worst - threshold) * 200;
	    formula.append(Double.toString(diNum2));
	    formula.append(RightBracker);
	    formula.append(Plus);
	    formula.append("50");

	    formula.append(Comma);
	    // formula.append("True");
	    formula.append("(");
	    formula.append(Double.toString(worst));
	    formula.append("<");
	    formula.append(currentName);
	    formula.append(")");
	    formula.append("&");
	    formula.append("(");
	    formula.append(currentName);
	    formula.append("<");
	    formula.append(Double.toString(threshold));
	    formula.append(")");
	    formula.append(RightBracker);
	    formula.append(Comma);

	    formula.append(LeftBracker);
	    formula.append("0");
	    formula.append(Comma);
	    formula.append("True");
	    formula.append(RightBracker);

	    formula.append(RightBracker);
	}
	if (worst > target) {
	    formula.append(LeftBracker);
	    formula.append("100");
	    formula.append(Comma);
	    formula.append(currentName);
	    formula.append("<=");
	    formula.append(Double.toString(target));
	    formula.append(RightBracker);
	    formula.append(Comma);

	    formula.append(LeftBracker);
	    formula.append("abs( ");
	    formula.append(LeftBracker);
	    formula.append(currentName);
	    formula.append(Minus);
	    formula.append(Double.toString(threshold));
	    formula.append(RightBracker);
	    formula.append(Divide);
	    double diNum = (target - threshold) * 200;
	    formula.append(Double.toString(diNum));
	    formula.append(RightBracker);
	    formula.append(Plus);
	    formula.append("50");

	    formula.append(Comma);
	    formula.append("(");
	    formula.append(Double.toString(target));
	    formula.append("<");
	    formula.append(currentName);
	    formula.append(")");
	    formula.append("&");
	    formula.append("(");
	    formula.append(currentName);
	    formula.append("<");
	    formula.append(Double.toString(threshold));
	    formula.append(")");
	    formula.append(RightBracker);
	    formula.append(Comma);

	    formula.append(LeftBracker);
	    formula.append("-abs( ");
	    formula.append(LeftBracker);
	    formula.append(currentName);
	    formula.append(Minus);
	    formula.append(Double.toString(threshold));
	    formula.append(RightBracker);
	    formula.append(Divide);
	    double diNum2 = (worst - threshold) * 200;
	    formula.append(Double.toString(diNum2));
	    formula.append(RightBracker);
	    formula.append(Plus);
	    formula.append("50");

	    formula.append(Comma);
	    // formula.append("True");
	    formula.append("(");
	    formula.append(Double.toString(threshold));
	    formula.append("<");
	    formula.append(currentName);
	    formula.append(")");
	    formula.append("&");
	    formula.append("(");
	    formula.append(currentName);
	    formula.append("<");
	    formula.append(Double.toString(worst));
	    formula.append(")");
	    formula.append(RightBracker);

	    formula.append(Comma);

	    formula.append(LeftBracker);
	    formula.append("0");
	    formula.append(Comma);
	    formula.append("True");
	    formula.append(RightBracker);

	    formula.append(RightBracker);
	}
	return formula;
    }

    // not working
    private void writeTranslation(URNspec urn) throws IOException {
	// 需要判断的 是actor 还是goal 还是indicator
	String modelName = urn.getName();
	write("modelName " + Equal + " '" + urn.getName() + "' " + "\n");
	StringBuffer varList = new StringBuffer();
	varList.append("List");
	varList.append(urn.getName());
	varList.append(Equal);
	varList.append("[");
	List<String> eleList = new ArrayList<String>();
	eleList.addAll(elementSet);
	// String message = String.join("-", list); 
	varList.append(String.join(",", eleList));
	varList.append("]");
	write(varList.toString());
	write("\n");

	StringBuffer tranScript = new StringBuffer();
	tranScript.append("Translate");
	tranScript.append(LeftBracker);
	tranScript.append("'");
	tranScript.append(modelFormula);
	tranScript.append("'");
	tranScript.append(Comma);
	tranScript.append("modelName");// model's name
	tranScript.append(Comma);
	tranScript.append("List");
	tranScript.append(urn.getName());
	tranScript.append(Comma);
	tranScript.append("LANG");
	tranScript.append(RightBracker);
	write("LANG = ''\n" + "langList = ['python','c','c++','java',\"javascript\",'matlab','r']\n");

	StringBuffer allprint = new StringBuffer();
	allprint.append("def allPrint():\n");
	allprint.append("\tfor j in langList:\n");
	allprint.append("\t\tLANG = str(j)\n");
	allprint.append("\t\t" + tranScript + "\n");
	write(allprint.toString());
	StringBuffer scriptLang = new StringBuffer(
		"if(len(sys.argv)==1):\n" + "\tallPrint()\n" + "else:\n" + "\tfor i in sys.argv:\n"
			+ "\t\tif(sys.argv.index(i)==0):continue\n" + "\t\tif  (i.lower() not in langList):\n"
			+ "\t\t\tfor j in langList:\n" + "\t\t\t\tLANG = str(j)\n" + "\t\t\t\t" + "allPrint()" + "\n"
			+ "\t\telse:\n" + "\t\t\tprint 'in'\n" + "\t\t\tLANG = str(i.lower())\n"
			// +"\t\t\tprint LANG\n"
			+ "\t\t\t" + tranScript + "\n");
	write(scriptLang.toString());

    }

    private String modifyName(String name) throws IOException {

	name = name.toLowerCase();
	name = name.substring(0, 1).toUpperCase() + name.substring(1);
	if (name.length() > 1) {
	    name = name.substring(0, name.length() - 1) + name.substring(name.length() - 1).toUpperCase();
	}

	name = name.replaceAll("[\\s]+", "_");
	name = name.replaceAll("[^a-zA-Z0-9\\_]+", "");
	Pattern pattern = Pattern.compile("^[0-9]");
	Matcher matcher = pattern.matcher(name);
	while (matcher.find()) {
	    name = "_" + name;
	}

	return name;
    }
}
