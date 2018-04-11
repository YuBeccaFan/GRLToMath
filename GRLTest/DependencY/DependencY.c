#include <stdio.h>

double DependencY( double D,double C,double B,double A){
	double expr = 1.0*fmin(A, fmin(B, fmin(C, D)));
	return expr;
}
