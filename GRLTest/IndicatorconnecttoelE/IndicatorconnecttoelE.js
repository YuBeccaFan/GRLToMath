function IndicatorconnecttoelE( Indicator3){
	expr = ((Indicator3 <= -100.0) ? (
   25.0
)
: ((Indicator3 >= -100.0 && Indicator3 < 200.0) ? (
   1.0*Math.min(100.0, 0.25*Math.abs(1.66666666666667e-5*Indicator3 - 0.00333333333333333) + 12.5)
)
: ((Indicator3 > 200.0 && Indicator3 < 500.0) ? (
   1.0*Math.max(0, -0.25*Math.abs(1.66666666666667e-5*Indicator3 - 0.00333333333333333) + 12.5)
)
: (
   0
))));
	return expr;
}
