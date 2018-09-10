package me.plaza235.diseasesim.diseases;

import me.plaza235.diseasesim.enums.Fatality;

public abstract class Disease {

	private String name;
	private int infectivity;
	private Fatality fatality;
	private int minIncubationTime;
	private int maxIncubationTime;
	private int timeSick;

	/**
	 * Constructor for a Disease object
	 * 
	 * @param infectivity
	 * @param isFatal
	 */
	public Disease(String name, int infectivity, Fatality fatality, int minIncubationTime, int maxIncubationTime, int timeSick) {
		this.name = name;
		this.infectivity = infectivity;
		this.fatality = fatality;
		this.minIncubationTime = minIncubationTime;
		this.maxIncubationTime = maxIncubationTime;
		this.timeSick = timeSick;
	}

	/**
	 * Returns boolean indicating if disease is fatal
	 * 
	 * @return
	 */
	public boolean isFatal() {
		if (fatality != Fatality.NONLETHAL) {
			return true;
		}
		return false;
	}

	public Fatality getFatality() {
		return fatality;
	}

	public int getInfectivity() {
		return infectivity;
	}

	public int getMinIncubationTime() {
		return minIncubationTime;
	}
	public int getMaxIncubationTime() {
		return maxIncubationTime;
	}
	
	public String getName() {
		return name;
	}
	
	public int getTimeSick() {
		return timeSick;
	}

}
