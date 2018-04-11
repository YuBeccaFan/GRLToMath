#include <stdio.h>

double OrdecompostioN( double D,double C,double B){
	double expr = 1.0*fmax(B, fmax(C, D));
	return expr;
}
