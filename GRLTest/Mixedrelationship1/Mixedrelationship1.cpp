#include <iostream>
using namespace std;

double Mixedrelationship1( double E,double D,double C,double B,double A){
	double expr = 1.0*std::min(E, std::max(0, std::min(100.0, 0.75*D + 1.0*std::max(B, C))));
	return expr;
}
