def IndicatorconnecttoelE( Indicator3):
	expr = ((25.0) if (Indicator3 <= -100.0) else (((1.0*min(100.0, 12.5*abs(0.00333333333333333*Indicator3 - 0.666666666666667) + 12.5)) if (Indicator3 <= 200.0) else (((1.0*max(0, -12.5*abs(0.00333333333333333*Indicator3 - 0.666666666666667) + 12.5)) if (Indicator3 < 500.0) else (((0) if (True) else None)))))))
	return expr
