package me.plaza235.diseasesim.diseases;

import me.plaza235.diseasesim.enums.Fatality;

public class CommonCold extends Disease {

	public CommonCold() {
		super("Common Cold", 10, Fatality.NONLETHAL, 1, 3, 14);
	}

}
