#include <iostream>
using namespace std;

double OrdecompostioN( double D,double C,double B){
	double expr = 1.0*std::max(B, std::max(C, D));
	return expr;
}
