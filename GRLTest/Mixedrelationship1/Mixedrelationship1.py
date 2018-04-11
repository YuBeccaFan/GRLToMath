def Mixedrelationship1( E,D,C,B,A):
	expr = 1.0*min(E, max(0, min(100.0, 0.75*D + 1.0*max(B, C))))
	return expr
