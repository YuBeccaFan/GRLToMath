function Mixedrelationship1( E,D,C,B,A){
	expr = 1.0*Math.min(E, Math.max(0, Math.min(100.0, 0.75*D + 1.0*Math.max(B, C))));
	return expr;
}
