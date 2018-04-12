#include <iostream>
using namespace std;

double MultirootmodeL( double J,double G){
	double expr = 0.25*std::max(0, std::min(100.0, std::min(-0.25*G, 0.25*J))) + 0.75*std::max(0, std::min(100.0, std::min(0.25*G, 0.75*J)));
	return expr;
}
