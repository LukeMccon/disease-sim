package me.plaza235.diseasesim.diseases;

import me.plaza235.diseasesim.enums.Fatality;

public class Influenza extends Disease {

	/**
	 * Creates the Influenza virus
	 * Highly infective and lethal to children and elderly
	 */
	public Influenza() {
		super("Influenza", 10, Fatality.LETHAL, 1, 3, 7);		
	}

}
