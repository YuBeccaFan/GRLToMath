#include <iostream>
using namespace std;

double AnddecompositioN( double D,double C,double B){
	double expr = 1.0*std::min(B, std::min(C, D));
	return expr;
}
