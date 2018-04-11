#include <iostream>
using namespace std;

double IndicatortargetlessthanworsT( double Indicator2){
	double expr = ((Indicator2 <= 100.0) ? (
   100.0
)
: ((Indicator2 < 500.0) ? (
   1.0*std::fabs(1.2500000000000001e-5*Indicator2 - 0.0062500000000000003) + 50.0
)
: ((Indicator2 > 500.0 && Indicator2 < 800.0) ? (
   -1.0*std::fabs(1.6666666666666667e-5*Indicator2 - 0.0083333333333333332) + 50.0
)
: (
   0
))));
	return expr;
}
