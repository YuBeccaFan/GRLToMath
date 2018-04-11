function IndicatortargetmorethanworsT( Indicator1){
	expr = ((Indicator1 >= 300.0) ? (
   100.0
)
: ((Indicator1 > 200.0) ? (
   1.0*Math.abs(5.0e-5*Indicator1 - 0.01) + 50.0
)
: ((Indicator1 > 30.0 && Indicator1 < 200.0) ? (
   -1.0*Math.abs(2.94117647058824e-5*Indicator1 - 0.00588235294117647) + 50.0
)
: (
   0
))));
	return expr;
}
