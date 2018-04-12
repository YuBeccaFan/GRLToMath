public class Model{
	public double Modeltest7(double D,double B){
		double expr = 0.5*Math.max(0, Math.min(100.0, 0.25*B)) + 0.5*Math.max(0, Math.min(100.0, 0.25*D + 0.25*Math.max(0, Math.min(100.0, 0.25*B))));
		return expr;
	}
}
