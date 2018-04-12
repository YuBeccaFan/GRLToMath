#include <stdio.h>

double IndicatortargetmorethanworsT( double Indicator1){
	double expr = ((Indicator1 >= 300.0) ? (
   100.0
)
: ((Indicator1 >= 200.0) ? (
   1.0*fabs(5.0000000000000002e-5*Indicator1 - 0.01) + 50.0
)
: ((Indicator1 > 30.0) ? (
   -1.0*fabs(2.9411764705882354e-5*Indicator1 - 0.0058823529411764705) + 50.0
)
: (
   0
))));
	return expr;
}
