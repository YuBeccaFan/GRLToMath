public class Model{
	public double Contribution2(double C,double B){
		double expr = 1.0*Math.max(0, Math.min(100.000000000000, 0.25*B - 0.25*C));
		return expr;
	}
}
