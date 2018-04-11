#include <iostream>
using namespace std;

double DependencY( double D,double C,double B,double A){
	double expr = 1.0*std::min(A, std::min(B, std::min(C, D)));
	return expr;
}
