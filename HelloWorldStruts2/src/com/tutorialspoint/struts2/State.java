package com.tutorialspoint.struts2;

public class State {
	private String state;
	private int population;
	
	public State() {}
	
	public State(String s, int p) {
		state = s;
		population = p;
	}

	

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}
	
	public String toString(){
		return this.getState()+" "+this.getPopulation();
	}
}
