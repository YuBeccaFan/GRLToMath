#include <stdio.h>

double Mixedrelationship1( double E,double D,double C,double B,double A){
	double expr = 1.0*fmin(E, fmax(0, fmin(100.0, 0.75*D + 1.0*fmax(B, C))));
	return expr;
}
