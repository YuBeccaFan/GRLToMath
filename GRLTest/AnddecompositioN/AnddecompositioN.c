#include <stdio.h>

double AnddecompositioN( double D,double C,double B){
	double expr = 1.0*fmin(B, fmin(C, D));
	return expr;
}
