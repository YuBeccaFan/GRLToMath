#include <iostream>
using namespace std;

double Contribution1( double B){
	double expr = 1.0*std::max(0, std::min(100.000000000000, 0.5*B));
	return expr;
}
