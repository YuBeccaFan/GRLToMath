function expr=Contribution2( C,B)
	expr = 1.0*max(0, min(100.000000000000, 0.25*B - 0.25*C))
end
