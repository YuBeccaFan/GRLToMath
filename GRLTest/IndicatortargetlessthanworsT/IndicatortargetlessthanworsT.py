def IndicatortargetlessthanworsT( Indicator2):
	expr = ((100.0) if (Indicator2 <= 100.0) else (((1.0*abs(1.25e-5*Indicator2 - 0.00625) + 50.0) if (Indicator2 >= 100.0 and Indicator2 < 500.0) else (((-1.0*abs(1.66666666666667e-5*Indicator2 - 0.00833333333333333) + 50.0) if (Indicator2 > 500.0 and Indicator2 < 800.0) else (((0) if (True) else None)))))))
	return expr
