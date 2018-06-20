#include <stdio.h>

double IndicatorconnecttoelE( double Indicator3){
	double expr = ((Indicator3 <= -100.0) ? (
   25.0
)
: ((Indicator3 <= 200.0) ? (
   1.0*fmin(100.0, 12.5*fabs(0.0033333333333333335*Indicator3 - 0.66666666666666674) + 12.5)
)
: ((Indicator3 < 500.0) ? (
   1.0*fmax(0, -12.5*fabs(0.0033333333333333335*Indicator3 - 0.66666666666666674) + 12.5)
)
: (
   0
))));
	return expr;
}
