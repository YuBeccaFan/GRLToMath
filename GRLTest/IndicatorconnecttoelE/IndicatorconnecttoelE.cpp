#include <iostream>
using namespace std;

double IndicatorconnecttoelE( double Indicator3){
	double expr = ((Indicator3 <= -100.0) ? (
   25.0
)
: ((Indicator3 >= -100.0 && Indicator3 < 200.0) ? (
   1.0*std::min(100.00000000000000, 0.25*std::fabs(1.6666666666666667e-5*Indicator3 - 0.0033333333333333335) + 12.5)
)
: ((Indicator3 > 200.0 && Indicator3 < 500.0) ? (
   1.0*std::max(0, -0.25*std::fabs(1.6666666666666667e-5*Indicator3 - 0.0033333333333333335) + 12.5)
)
: (
   0
))));
	return expr;
}
