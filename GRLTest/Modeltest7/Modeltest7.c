#include <stdio.h>

double Modeltest7( double D,double B){
	double expr = 0.5*fmax(0, fmin(100.0, 0.25*B)) + 0.5*fmax(0, fmin(100.0, 0.25*D + 0.25*fmax(0, fmin(100.0, 0.25*B))));
	return expr;
}
