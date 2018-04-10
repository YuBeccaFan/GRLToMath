#Translation.py
from sympy import *
from MathToJava import *
from MathToC import *
from MathToCpp import *
from MathToJS import *
from MathToPython import *
from MathToMatlab import *
from MathToR import *
from MathToLang import *
init_printing()

''' translate Sympy formula into target language
	Java
	Matlab
	C
	C++
	JavaScript
	Python
'''
'''
formula e.g Max(x,y)
dep dependent variable
args the element in formula
Type :
Java
Matlab
C
C++
JavaScript
Python
'''
def Translate(formula,dep,args,Type):
    #func = formula.split('(')
    #if(func[0] == "Piecewise"):

    
    i = 0
    for arg in args:
        print arg
        arg = str(arg)+"="+"Symbol"+"("+"'"+str(arg)+"'"+")"
        i = i+1
        #print arg
        exec(arg)
        
    func = simplify(eval(formula)).evalf()
    print func
    if Type == "java":
        #print jcode(eval(func))
        convertToJava(jcode(func),dep,args).writeMath()
        #MathToJava.writeMath(jcode(eval(formula)),dep,args)
        return
    if Type == "python":
        print "python !"
        from sympy.printing.pycode import (PythonCodePrinter,pycode)
        pr = PythonCodePrinter()
        convertToPy( pr.doprint(func),dep,args).writeMath()
        return
    if Type == "javascript":
        convertToJS(jscode(func),dep,args).writeMath()
        return
    if Type == "matlab":
        convertToMatlab(octave_code(func),dep,args).writeMath()
        return

    if Type == "c":
        convertToC(ccode(func),dep,args).writeMath()
        return
    if Type == "c++":
        convertToCpp(cxxcode(func),dep,args).writeMath()
        return
    if Type == "r":
        convertToR(rcode(func),dep,args).writeMath()
        return



'''
test
print Translate('E1=Min(E2,E3)',"Java")'''
