public class Model{
	public double MultirootmodeL(double J,double G){
		double expr = 0.25*Math.max(0, Math.min(100.0, Math.min(-0.25*G, 0.25*J))) + 0.75*Math.max(0, Math.min(100.0, Math.min(0.25*G, 0.75*J)));
		return expr;
	}
}
