package by.ittc.horsebetting.model;

import java.util.List;

public class Jockej {
	
	
	private String name;
	private String lastName;
	private List<Race> hesRaces;
	
	
	public Jockej() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<Race> getHesRaces() {
		return hesRaces;
	}
	public void setHesRaces(List<Race> hesRaces) {
		this.hesRaces = hesRaces;
	}
	
	

}
