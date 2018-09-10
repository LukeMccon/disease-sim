package me.plaza235.diseasesim;

import me.plaza235.diseasesim.diseases.CommonCold;
import me.plaza235.diseasesim.diseases.Disease;
import me.plaza235.diseasesim.diseases.Influenza;
import me.plaza235.diseasesim.diseases.LowContagion;

public class Simulator {

	private static final int POPULATION = 10000;
	private static final int VACCINATED = 8500;
	private static final int INTERACTIONS = 15;

	private static Disease disease = new LowContagion();
	private static Disease disease2 = new Influenza();
	private static Disease disease3 = new CommonCold();

	public static void main(String[] args) {

		runSimulation(disease);
		runSimulation(disease2);
		runSimulation(disease3);

		runSingleSimulation(disease2);

	}

	/**
	 * Runs a series of simulations with a specified disease
	 * 
	 * @param disease
	 */
	public static void runSimulation(Disease disease) {

		int maxSick = 0;
		int minSick = POPULATION;

		int maxHealthy = 0;
		int minHealthy = POPULATION;

		int maxFreeRiders = 0;
		int minFreeRiders = POPULATION;

		int maxDead = 0;
		int minDead = POPULATION;

		int maxWasSick = 0;
		int minWasSick = POPULATION;

		long totalSick = 0;
		long totalHealthy = 0;
		long totalFreeRiders = 0;
		long totalDead = 0;
		long totalWasSick = 0;

		double averageSick;
		double averageHealthy;
		double averageFreeRiders;
		double averageDead;
		double averageWasSick;

		int maxSims = 20;

		for (int i = 1; i <= maxSims; i++) {

			// System.out.println("Running Simulation " + i + " of " + maxSims);

			Town town = new Town(POPULATION, INTERACTIONS, disease);
			town.populateTown();
			town.infectCitizen();
			town.vaccinateCitizens(VACCINATED);
			town.passTime();

			int sickPeople = town.numberOfSick();
			totalSick += sickPeople;

			int deadPeople = town.numberOfDead();
			totalDead += deadPeople;

			int healthyPeople = POPULATION - (sickPeople + deadPeople);
			totalHealthy += healthyPeople;

			int freeRiders = (healthyPeople) - VACCINATED;
			totalFreeRiders += freeRiders;

			int wasSick = town.numberWasSick();
			totalWasSick += wasSick;

			if (sickPeople > maxSick) {
				maxSick = sickPeople;
			}

			if (sickPeople < minSick) {
				minSick = sickPeople;
			}

			if (healthyPeople > maxHealthy) {
				maxHealthy = healthyPeople;
			}

			if (healthyPeople < minHealthy) {
				minHealthy = healthyPeople;
			}

			if (freeRiders > maxFreeRiders) {
				maxFreeRiders = freeRiders;
			}

			if (freeRiders < minFreeRiders) {
				minFreeRiders = freeRiders;
			}

			if (deadPeople > maxDead) {
				maxDead = deadPeople;
			}

			if (deadPeople < minDead) {
				minDead = deadPeople;
			}

			if (wasSick > maxWasSick) {
				maxWasSick = wasSick;
			}

			if (wasSick < minWasSick) {
				minWasSick = wasSick;
			}

		}
		averageSick = totalSick / (double) maxSims;
		averageHealthy = totalHealthy / (double) maxSims;
		averageFreeRiders = totalFreeRiders / (double) maxSims;
		averageDead = totalDead / (double) maxSims;
		averageWasSick = totalWasSick / (double) maxSims;

		System.out.println("Value\t\tMax\tMin\tAvg");
		System.out.println();
		System.out.println("Sick\t\t" + maxSick + "\t" + minSick + "\t" + averageSick);
		System.out.println("Was Sick\t" + maxWasSick + "\t" + minWasSick + "\t" + averageWasSick);
		System.out.println("Healthy\t\t" + maxHealthy + "\t" + minHealthy + "\t" + averageHealthy);
		System.out.println("Free Riders\t" + maxFreeRiders + "\t" + minFreeRiders + "\t" + averageFreeRiders);
		System.out.println("Deaths\t\t" + maxDead + "\t" + minDead + "\t" + averageDead);
		System.out.println("Simulation of " + POPULATION + " people and " + VACCINATED + " vaccinated people");
		System.out.println("Tested with an outbreak of " + disease.getName() + "\n\n");

	}

	/**
	 * Runs a single simulation with a specified disease
	 * 
	 * @param disease
	 */
	public static void runSingleSimulation(Disease disease) {

		Town town = new Town(POPULATION, INTERACTIONS, disease);
		town.populateTown();
		town.infectCitizen();
		town.vaccinateCitizens(VACCINATED);
		town.passTime();

		System.out.println("Sick\t\t" + town.numberOfSick());
		System.out.println("Was Sick\t" + town.numberWasSick());
		System.out.println("Healthy\t\t" + (POPULATION - (town.numberOfSick() + town.numberOfDead())));
		System.out.println("Free Riders\t" + ((POPULATION - (town.numberOfSick() + town.numberOfDead())) - VACCINATED));
		System.out.println("Deaths\t\t" + town.numberOfDead());

		System.out.println("Simulation of " + POPULATION + " people and " + VACCINATED + " vaccinated people");
		System.out.println("Tested with an outbreak of " + disease.getName() + "\n\n");

	}
}
