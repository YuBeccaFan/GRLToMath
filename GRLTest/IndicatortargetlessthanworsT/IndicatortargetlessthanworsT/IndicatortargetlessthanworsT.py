def IndicatortargetlessthanworsT( Indicator2):
	expr = ((100.0) if (Indicator2 <= 100.0) else (((50.0*abs(0.0025*Indicator2 - 1.25) + 50.0) if (Indicator2 <= 500.0) else (((-50.0*abs(0.00333333333333333*Indicator2 - 1.66666666666667) + 50.0) if (Indicator2 < 800.0) else (((0) if (True) else None)))))))
	return expr
