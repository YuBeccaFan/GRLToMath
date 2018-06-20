function IndicatortargetlessthanworsT( Indicator2){
	expr = ((Indicator2 <= 100.0) ? (
   100.0
)
: ((Indicator2 <= 500.0) ? (
   50.0*Math.abs(0.0025*Indicator2 - 1.25) + 50.0
)
: ((Indicator2 < 800.0) ? (
   -50.0*Math.abs(0.00333333333333333*Indicator2 - 1.66666666666667) + 50.0
)
: (
   0
))));
	return expr;
}
