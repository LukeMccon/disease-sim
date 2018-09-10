package me.plaza235.diseasesim;

import java.util.ArrayList;

public class DiseaseSim {
	
	
	
	public static void main(String[] args) {
		
		
		
		int population = 10000;
		int vaccinated = 9500;
		for(int i = 0; i < 1000; i++)
		{
			Town town = new Town(population);
			town.populateTown();
			town.infectCitizen();
			town.vaccinateCitizens(vaccinated);
			town.passTime();
			
			System.out.println("Number of sick: " + town.numberOfSick());
			System.out.println("Number of healthy: " + (population - town.numberOfSick()));
			System.out.println("Number of free riders: " + ((population - town.numberOfSick()) - vaccinated));
			double percentOfFreeRiders = (((population - town.numberOfSick()) - vaccinated) / (double)(population - vaccinated)) * 100;
			System.out.println("Percent of free riders: " + percentOfFreeRiders + "%");
			
		}
		
	}

}
