def IndicatortargetmorethanworsT( Indicator1):
	expr = ((100.0) if (Indicator1 >= 300.0) else (((50.0*abs(0.01*Indicator1 - 2.0) + 50.0) if (Indicator1 >= 200.0) else (((-50.0*abs(0.00588235294117647*Indicator1 - 1.17647058823529) + 50.0) if (Indicator1 > 30.0) else (((0) if (True) else None)))))))
	return expr
