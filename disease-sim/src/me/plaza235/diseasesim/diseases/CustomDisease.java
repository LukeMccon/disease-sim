package me.plaza235.diseasesim.diseases;

import me.plaza235.diseasesim.enums.Fatality;

public class CustomDisease extends Disease {

	public CustomDisease(String name, int infectivity, Fatality fatality, int minIncubationTime, int maxIncubationTime,
			int timeSick) {
		super(name, infectivity, fatality, minIncubationTime, maxIncubationTime, timeSick);
	}

}
