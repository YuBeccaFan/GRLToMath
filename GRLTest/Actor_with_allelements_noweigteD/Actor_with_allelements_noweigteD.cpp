#include <iostream>
using namespace std;

double Actor_with_allelements_noweigteD( double E,double D,double C){
	double expr = 0.5*E + 0.5*std::min(C, D);
	return expr;
}
