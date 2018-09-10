package me.plaza235.diseasesim;

public class Person {
	
	/**
	 * stores whether a person is sick (true) or not sick (false)
	 */
	private boolean isSick; 
	/**
	 * 
	 */
	private boolean isVaccinated;
	
	/**
	 * default constructor to create a healthy individual
	 */
	public Person() {
		isSick = false;
	}
	
	/**
	 * getter for isSick instance variable
	 * @return boolean true if sick, false if not
	 */
	public boolean isSick() {
		return isSick;
	}
	/**
	 * setter for isSick instance variable
	 * @param isSick value to be set into object
	 */
	public void setSick(boolean isSick) {
		this.isSick = isSick;
	}
	
	public boolean isVaccinated() {
		return isVaccinated;
	}

	public void setVaccinated(boolean isVaccinated) {
		this.isVaccinated = isVaccinated;
	}
	
	
	
	/**
	 * 
	 * @param otherPerson
	 */
	public void interact(Person otherPerson) {
		if(otherPerson.isSick()) {
			setSick(true);
		}
	}

	
	
}
