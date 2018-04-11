function Contribution2( C,B){
	expr = 1.0*Math.max(0, Math.min(100.0, 0.25*B - 0.25*C));
	return expr;
}
