function IndicatortargetmorethanworsT( Indicator1){
	expr = ((Indicator1 >= 300.0) ? (
   100.0
)
: ((Indicator1 >= 200.0) ? (
   50.0*Math.abs(0.01*Indicator1 - 2.0) + 50.0
)
: ((Indicator1 > 30.0) ? (
   -50.0*Math.abs(0.00588235294117647*Indicator1 - 1.17647058823529) + 50.0
)
: (
   0
))));
	return expr;
}
