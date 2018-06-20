public class Model{
	public double IndicatorconnecttoelE(double Indicator3){
		double expr = ((Indicator3 <= -100.0) ? (
   25.0
)
: ((Indicator3 <= 200.0) ? (
   1.0*Math.min(100.00000000000000, 12.5*Math.abs(0.00333333333333333*Indicator3 - 0.666666666666667) + 12.5)
)
: ((Indicator3 < 500.0) ? (
   1.0*Math.max(0, -12.5*Math.abs(0.00333333333333333*Indicator3 - 0.666666666666667) + 12.5)
)
: (
   0
))));
		return expr;
	}
}
