public class Model{
	public double Actor_with_allelements_noweigteD(double E,double D,double C){
		double expr = 0.5*E + 0.5*Math.min(C, D);
		return expr;
	}
}
