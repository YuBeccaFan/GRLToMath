#include <iostream>
using namespace std;

double Modeltest7( double D,double B){
	double expr = 0.5*std::max(0, std::min(100.0, 0.25*B)) + 0.5*std::max(0, std::min(100.0, 0.25*D + 0.25*std::max(0, std::min(100.0, 0.25*B))));
	return expr;
}
