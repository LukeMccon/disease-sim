package me.plaza235.diseasesim;

import java.util.Random;

import me.plaza235.diseasesim.diseases.Disease;

public class Person {

	/** Instance booleans */
	private boolean isSick;
	private boolean wasSick;
	private boolean isVaccinated;
	private boolean isContagious;
	private boolean isDead = false;

	/** Instance ints */
	private int incubationTime;
	private int interactions;
	private int timeToBeSick = -1;

	/** Other Instance variables */
	private Disease disease;

	/**
	 * default constructor to create a healthy individual
	 */
	public Person(int interactions, Disease disease) {
		isSick = false;
		this.interactions = interactions;
		this.disease = disease;
	}

	/**
	 * getter for isSick instance variable
	 * 
	 * @return boolean true if sick, false if not
	 */
	public boolean isSick() {
		return isSick;
	}

	/**
	 * setter for isSick instance variable
	 * 
	 * @param isSick value to be set into object
	 */
	public void setSick(boolean isSick) {
		this.isSick = isSick;

		if (isSick) {
			this.wasSick = true;
		}

		Random random = new Random();

		incubationTime = random.nextInt(disease.getMaxIncubationTime() - disease.getMaxIncubationTime() + 1)
				+ disease.getMaxIncubationTime();

		timeToBeSick = disease.getTimeSick();

	}

	public boolean isVaccinated() {
		return isVaccinated;
	}

	public boolean isContagious() {
		return isContagious;
	}

	public void setVaccinated(boolean isVaccinated) {
		this.isVaccinated = isVaccinated;
	}

	public void setContagious(boolean isContagious) {
		this.isContagious = isContagious;
	}

	public int getInteractions() {
		return interactions;
	}

	public boolean isDead() {
		return isDead;
	}

	public boolean wasSick() {
		return wasSick;
	}

	public void kill() {
		this.isDead = true;
	}

	/**
	 * Ticks to reduce incubation time of disease
	 */
	public void tickIncubation() {

		if (isSick() && !isContagious()) {
			incubationTime--;
			if (incubationTime == 0) {
				setContagious(true);
			}
		}

	}

	/**
	 * Ticks to see if person will reduce their time sick
	 */
	public void tickTimeSick() {

		if (isSick() && !isDead()) {
			timeToBeSick--;
		}
		if (timeToBeSick == 0) {
			setContagious(false);
			setSick(false);
			setVaccinated(true);
		}
	}

	/**
	 * Ticks to determine if person dies
	 * 
	 * @param disease
	 */
	public void tickDeath() {

		if (!disease.isFatal()) {
			// Woo hoo you didn't die			
		} else if (disease.isFatal() && isContagious()) {
			Random random = new Random();

			if (random.nextInt(100) == 57) {
				kill();
			}

		}

	}

	/**
	 * Interacts with the other person, deciding if this person becomes sick
	 * 
	 * @param otherPerson
	 */
	public void interact(Person otherPerson, Disease disease) {

		Random random = new Random();

		if (otherPerson.isContagious() && !isVaccinated()) {

			// If randomly infected
			if (random.nextInt(10) <= disease.getInfectivity()) {
				setSick(true);
			}
		}
	}

}
