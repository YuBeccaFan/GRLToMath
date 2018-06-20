#include <iostream>
using namespace std;

double IndicatortargetmorethanworsT( double Indicator1){
	double expr = ((Indicator1 >= 300.0) ? (
   100.0
)
: ((Indicator1 >= 200.0) ? (
   50.0*std::fabs(0.01*Indicator1 - 2.0) + 50.0
)
: ((Indicator1 > 30.0) ? (
   -50.0*std::fabs(0.0058823529411764705*Indicator1 - 1.1764705882352942) + 50.0
)
: (
   0
))));
	return expr;
}
