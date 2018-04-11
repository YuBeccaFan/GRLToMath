#include <iostream>
using namespace std;

double Contribution2( double C,double B){
	double expr = 1.0*std::max(0, std::min(100.000000000000, 0.25*B - 0.25*C));
	return expr;
}
