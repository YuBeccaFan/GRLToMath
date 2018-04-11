#include <stdio.h>

double Contribution2( double C,double B){
	double expr = 1.0*fmax(0, fmin(100.0, 0.25*B - 0.25*C));
	return expr;
}
