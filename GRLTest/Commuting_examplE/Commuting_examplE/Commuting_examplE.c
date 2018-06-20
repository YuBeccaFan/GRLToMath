#include <stdio.h>

double Commuting_examplE( double Express_buS,double Regular_buS,double Average_work_timE,double Hitch_a_ridE,double Minimize_infrastructure_cosT,double Minimize_travel_timE,double Average_ongoing_cosT,double Take_own_caR){
	double expr = 0.66666412353515625*fmax(0, fmin(100.0, 0.59999847412109375*Minimize_infrastructure_cosT + 0.40000152587890625*fmax(0, fmin(100.0, 1.0*((Average_ongoing_cosT <= 60.0) ? (
   100.0
)
: ((Average_ongoing_cosT <= 100.0) ? (
   50.0*fabs(0.025000000000000001*Average_ongoing_cosT - 2.5) + 50.0
)
: ((Average_ongoing_cosT < 200.0) ? (
   -50.0*fabs(0.01*Average_ongoing_cosT - 1.0) + 50.0
)
: (
   0
)))))))) + 0.66666412353515625*fmax(0, fmin(100.0, 0.5*Minimize_travel_timE + 0.5*fmax(0, fmin(100.0, 1.0*((Average_work_timE >= 60.0) ? (
   100.0
)
: ((Average_work_timE >= 5.0) ? (
   50.0*fabs(0.018181818181818181*Average_work_timE - 0.090909090909090912) + 50.0
)
: ((Average_work_timE > 0) ? (
   -50.0*fabs(0.20000000000000001*Average_work_timE - 1.0) + 50.0
)
: (
   0
))))))));
	return expr;
}
