function Commuting_examplE( Express_buS,Regular_buS,Average_work_timE,Hitch_a_ridE,Minimize_infrastructure_cosT,Minimize_travel_timE,Average_ongoing_cosT,Take_own_caR){
	expr = 0.6667*Math.max(0, Math.min(100.0, 0.6*Minimize_infrastructure_cosT + 0.4*Math.max(0, Math.min(100.0, 1.0*((Average_ongoing_cosT <= 60.0) ? (
   100.0
)
: ((Average_ongoing_cosT >= 60.0 && Average_ongoing_cosT < 100.0) ? (
   Math.abs(0.000125*Average_ongoing_cosT - 0.0125) + 50.0
)
: ((Average_ongoing_cosT > 100.0 && Average_ongoing_cosT < 200.0) ? (
   -Math.abs(5.0e-5*Average_ongoing_cosT - 0.005) + 50.0
)
: (
   0
)))))))) + 0.6667*Math.max(0, Math.min(100.0, 0.5*Minimize_travel_timE + 0.5*Math.max(0, Math.min(100.0, 1.0*((Average_work_timE >= 60.0) ? (
   100.0
)
: ((Average_work_timE >= 5.0) ? (
   Math.abs(9.09090909090909e-5*Average_work_timE - 0.000454545454545455) + 50.0
)
: ((Average_work_timE > 0) ? (
   -Math.abs(0.001*Average_work_timE - 0.005) + 50.0
)
: (
   0
))))))));
	return expr;
}
