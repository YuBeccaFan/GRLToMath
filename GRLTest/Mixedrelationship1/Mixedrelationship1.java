public class Model{
	public double Mixedrelationship1(double E,double D,double C,double B,double A){
		double expr = 1.0*Math.min(E, Math.max(0, Math.min(100.0, 0.75*D + 1.0*Math.max(B, C))));
		return expr;
	}
}
