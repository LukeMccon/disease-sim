package me.plaza235.diseasesim;

import java.util.ArrayList;
import java.util.Random;

public class Town {
	
	private ArrayList<Person> citizens;
	private int totalPopulation;
	private int interactionsPerDay = 10;

	/**
	 * Create a new town
	 */
	public Town(int totalPopulation) {
		
		this.totalPopulation = totalPopulation;
		
	}
	
	/**
	 * Populate town with totalPopulation of citizens
	 */
	public void populateTown() {
		
		citizens = new ArrayList<Person>();
		
		for(int i = 0; i < totalPopulation; i++) {
			
			citizens.add(new Person());
			
		}
		
	}
	
	/**
	 * Infect a random citizen in the town
	 */
	public void infectCitizen() {
		
		Random random = new Random();
		int someCitizen = random.nextInt(totalPopulation);
		
		citizens.get(someCitizen).setSick(true);
		
	}
	
	public void vaccinateCitizens(int toVaccinate) {
		
		Random random = new Random();
		
		for(int i = 0; i < toVaccinate; i++) {
			
			Person someCitizen = citizens.get(random.nextInt(totalPopulation));
			
			if(someCitizen.isVaccinated() || someCitizen.isSick()) {
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
		for(int i = 0; i < 7; i++) {
			
			for(int j = 0; j < (interactionsPerDay * totalPopulation); j++) {
				
				Person citizenOne;
				Person citizenTwo;
				
				do {
					citizenOne = citizens.get(random.nextInt(totalPopulation));
					citizenTwo = citizens.get(random.nextInt(totalPopulation));
				} while(citizenOne.equals(citizenTwo));
				
				citizenOne.interact(citizenTwo);
				citizenTwo.interact(citizenOne);
				
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
		
		for(Person p : citizens) {
			if(p.isSick()) {
				totalSick++;
			}
		}
		
		return totalSick;
		
	}
	
}
