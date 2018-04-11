public class Model{
	public double DependencY(double D,double C,double B,double A){
		double expr = 1.0*Math.min(A, Math.min(B, Math.min(C, D)));
		return expr;
	}
}
