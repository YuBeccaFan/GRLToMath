#include <stdio.h>

double Contribution1( double B){
	double expr = 1.0*fmax(0, fmin(100.0, 0.5*B));
	return expr;
}
