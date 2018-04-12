def IndicatorconnecttoelE( Indicator3):
	expr = ((25.0) if (Indicator3 <= -100.0) else (((1.0*min(100.0, 0.25*abs(1.66666666666667e-5*Indicator3 - 0.00333333333333333) + 12.5)) if (Indicator3 >= -100.0 and Indicator3 < 200.0) else (((1.0*max(0, -0.25*abs(1.66666666666667e-5*Indicator3 - 0.00333333333333333) + 12.5)) if (Indicator3 > 200.0 and Indicator3 < 500.0) else (((0) if (True) else None)))))))
	return expr
