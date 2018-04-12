def IndicatortargetmorethanworsT( Indicator1):
	expr = ((100.0) if (Indicator1 >= 300.0) else (((1.0*abs(5.0e-5*Indicator1 - 0.01) + 50.0) if (Indicator1 >= 200.0) else (((-1.0*abs(2.94117647058824e-5*Indicator1 - 0.00588235294117647) + 50.0) if (Indicator1 > 30.0) else (((0) if (True) else None)))))))
	return expr
