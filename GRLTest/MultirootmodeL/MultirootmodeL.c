#include <stdio.h>

double MultirootmodeL( double J,double G){
	double expr = 0.25*fmax(0, fmin(100.0, fmin(-0.25*G, 0.25*J))) + 0.75*fmax(0, fmin(100.0, fmin(0.25*G, 0.75*J)));
	return expr;
}
