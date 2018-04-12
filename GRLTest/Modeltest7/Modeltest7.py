def Modeltest7( D,B):
	expr = 0.5*max(0, min(100.0, 0.25*B)) + 0.5*max(0, min(100.0, 0.25*D + 0.25*max(0, min(100.0, 0.25*B))))
	return expr
