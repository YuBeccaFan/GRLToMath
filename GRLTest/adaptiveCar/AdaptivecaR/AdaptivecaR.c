#include <stdio.h>

double AdaptivecaR( double Manage_speeD,double VibratioN,double Electric_enginE,double DistancE,double Fuel_enginE){
	double expr = 0.40000152587890625*fmax(0, fmin(100.0, -0.25*Electric_enginE + 0.5*Fuel_enginE)) + 0.40000152587890625*fmax(0, fmin(100.0, 0.5*Electric_enginE - 0.25*Fuel_enginE + 0.5*((VibratioN <= 0.0) ? (
   100.0
)
: ((VibratioN <= 10.0 && VibratioN > 0) ? (
   50.0*fabs(0.10000000000000001*VibratioN - 1.0) + 50.0
)
: ((VibratioN > 10.0 && VibratioN < 20.0) ? (
   -50.0*fabs(0.10000000000000001*VibratioN - 1.0) + 50.0
)
: (
   0
)))))) + 0.59999847412109375*fmax(0, fmin(100.0, fmin(-0.5*Manage_speeD + 1.0*fmax(Electric_enginE, Fuel_enginE), fmax(Manage_speeD, 1.0*((DistancE >= 25.0) ? (
   100.0
)
: ((DistancE >= 10.0) ? (
   50.0*fabs(0.066666666666666666*DistancE - 0.66666666666666663) + 50.0
)
: ((DistancE > 5.0) ? (
   -50.0*fabs(0.20000000000000001*DistancE - 2.0) + 50.0
)
: (
   0
))))))));
	return expr;
}
