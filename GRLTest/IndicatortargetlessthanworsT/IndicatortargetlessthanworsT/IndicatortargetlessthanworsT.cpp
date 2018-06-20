#include <iostream>
using namespace std;

double IndicatortargetlessthanworsT( double Indicator2){
	double expr = ((Indicator2 <= 100.0) ? (
   100.0
)
: ((Indicator2 <= 500.0) ? (
   50.0*std::fabs(0.0025000000000000001*Indicator2 - 1.25) + 50.0
)
: ((Indicator2 < 800.0) ? (
   -50.0*std::fabs(0.0033333333333333335*Indicator2 - 1.6666666666666667) + 50.0
)
: (
   0
))));
	return expr;
}
