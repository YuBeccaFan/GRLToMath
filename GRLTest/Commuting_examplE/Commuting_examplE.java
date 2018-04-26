public class Model{
	public double Commuting_examplE(double Express_buS,double Regular_buS,double Average_work_timE,double Hitch_a_ridE,double Minimize_infrastructure_cosT,double Minimize_travel_timE,double Average_ongoing_cosT,double Take_own_caR){
		double expr = 0.6667*Math.max(0, Math.min(100.0, 0.6*Minimize_infrastructure_cosT + 0.4*Math.max(0, Math.min(100.0, 1.0*((Average_ongoing_cosT <= 60.0) ? (
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
}
