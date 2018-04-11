function expr=DependencY( D,C,B,A)
	expr = 1.0*min(A, min(B, min(C, D)))
end
