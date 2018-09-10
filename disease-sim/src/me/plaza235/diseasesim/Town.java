package me.plaza235.diseasesim;

import java.util.ArrayList;
import java.util.Random;

import me.plaza235.diseasesim.diseases.Disease;

public class Town {

	private ArrayList<Person> citizens;
	private int totalPopulation;
	private int interactions;
	private int simulationTime;
	private Disease disease;

	/**
	 * Create a new town
	 */
	public Town(int totalPopulation, int interactions, int simulationTime, Disease disease) {

		this.totalPopulation = totalPopulation;
		this.interactions = interactions;
		this.simulationTime = simulationTime;
		this.disease = disease;

	}

	/**
	 * Populate town with totalPopulation of citizens
	 */
	public void populateTown() {

		citizens = new ArrayList<Person>();

		for (int i = 0; i < totalPopulation; i++) {

			citizens.add(new Person(interactions, disease));

		}

	}

	/**
	 * Infect a random citizen in the town
	 */
	public void infectCitizen() {

		Random random = new Random();
		int someCitizen = random.nextInt(totalPopulation);

		// Start citizen off as being already contagious
		Person citizen = citizens.get(someCitizen);
		citizen.setContagious(true);
		citizen.setSick(true);

	}

	/**
	 * Vaccinates some passed about of people
	 * 
	 * @param toVaccinate
	 */
	public void vaccinateCitizens(int toVaccinate) {

		Random random = new Random();

		for (int i = 0; i < toVaccinate; i++) {

			Person someCitizen = citizens.get(random.nextInt(totalPopulation));

			if (someCitizen.isVaccinated() || someCitizen.isSick()) {
				i--;
			} else {
				someCitizen.setVaccinated(true);
			}

		}

	}

	/**
	 * Pass one week of time in the town
	 */
	public void passTime() {

		Random random = new Random();

		// Pass time in town for 7 days
		for (int i = 0; i < simulationTime; i++) {

			for (Person p : citizens) {

				if (!p.isDead()) {

					for (int j = 0; j < p.getInteractions(); j++) {

						Person otherCitizen;

						do {
							otherCitizen = citizens.get(random.nextInt(totalPopulation));
						} while (p.equals(otherCitizen));

						p.interact(otherCitizen, disease);

					}

					p.tickIncubation();
					p.tickDeath();
					p.tickTimeSick();
				}
			}

		}

	}

	/**
	 * Returns number of people who are infected in the town
	 * 
	 * @return number of sick people
	 */
	public int numberOfSick() {

		int totalSick = 0;

		for (Person p : citizens) {
			if (p.isSick() && !p.isDead()) {
				totalSick++;
			}
		}

		return totalSick;

	}
	/**
	 * Returns number of people who died as a result of the disease
	 *
	 * @return number of dead people
	 */
	public int numberOfDead() {

		int totalDead = 0;

		for (Person p : citizens) {
			if (p.isDead()) {
				totalDead++;
			}
		}

		return totalDead;
	}


	/**
	 * returns people who were infected at some point in the town
	 *
	 *@return total of people who developed and carried the disease in the alloted time
	 */
	public int numberWasSick() {

		int totalWasSick = 0;

		for (Person p : citizens) {
			if (p.wasSick()) {
				totalWasSick++;
			}
		}

		return totalWasSick;
	}

}
