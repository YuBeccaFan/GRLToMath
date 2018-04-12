function expr=MultirootmodeL( J,G)
	expr = 0.25*max(0, min(100.0, min(-0.25*G, 0.25*J))) + 0.75*max(0, min(100.0, min(0.25*G, 0.75*J)))
end
