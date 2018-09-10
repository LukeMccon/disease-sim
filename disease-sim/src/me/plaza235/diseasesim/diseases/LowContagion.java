package me.plaza235.diseasesim.diseases;

import me.plaza235.diseasesim.enums.Fatality;

public class LowContagion extends Disease {

	public LowContagion() {
		super("Low Contagion", 1, Fatality.NONLETHAL, 0, 1, 7);
	}

}
