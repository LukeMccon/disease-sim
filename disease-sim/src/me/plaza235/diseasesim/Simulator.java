package me.plaza235.diseasesim;

public class Simulator {
	private static final int POPULATION = 10000;
	private static final int VACCINATED = 9000;
	public static void main(String [] args){
		int maxSick = 0; 
		int minSick = POPULATION;
		
		int maxHealthy = 0;
		int minHealthy = POPULATION;
		
		int maxFreeRiders = 0;
		int minFreeRiders = POPULATION;
		
		long totalSick = 0;
		long totalHealthy = 0;
		long totalFreeRiders = 0;
		
		double averageSick;
		double averageHealthy;
		double averageFreeRiders;
		
		for(int i = 0; i < 100; i++){
			Town town = new Town(POPULATION);
			town.populateTown();
			town.infectCitizen();
			town.vaccinateCitizens(VACCINATED);
			town.passTime();
			
			int sickPeople = town.numberOfSick();
				totalSick += sickPeople;
			
			int healthyPeople = POPULATION - sickPeople;
				totalHealthy += healthyPeople;
			
			int freeRiders = (POPULATION - sickPeople) - VACCINATED;
				totalFreeRiders += freeRiders;
			
			if(sickPeople > maxSick) {
				maxSick = sickPeople;
			}
			
			if(sickPeople < minSick) {
				minSick = sickPeople;
			}
			
			if(healthyPeople > maxHealthy) {
				maxHealthy = healthyPeople;
			}
			
			if(healthyPeople < minHealthy) {
				minHealthy = healthyPeople;
			}
			
			if(freeRiders > maxFreeRiders) {
				maxFreeRiders = freeRiders;
			}
			
			if(freeRiders < minFreeRiders) {
				minFreeRiders = freeRiders;
			}
			
			 
		}
		averageSick = (double) totalSick / 100;
		averageHealthy = (double) totalHealthy / 100;
		averageFreeRiders = (double) totalFreeRiders / 100;
		
		System.out.println("Value\t\tMax\tMin\tAvg");
		System.out.println("Sick\t\t" + maxSick + "\t" + minSick + "\t" + averageSick);
		System.out.println("Healthy\t\t" + maxHealthy + "\t" + minHealthy + "\t" + averageHealthy);
		System.out.println("Free Riders\t" + maxFreeRiders + "\t" + minFreeRiders + "\t" + averageFreeRiders);
	}
}
