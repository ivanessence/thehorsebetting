package by.ittc.horsebetting.model;

import java.util.List;

public class Administrator extends User {
	
	private final static String access = "Administrator";
	private List<Race> allRaces;
	private List<Bet> allBets;
	
	
	public Administrator() {
		super();
	}
	
	
	
	public String getAccess() {
		return access;
	}

	public List<Race> getAllRaces() {
		return allRaces;
	}
	public void setAllRaces(List<Race> allRaces) {
		this.allRaces = allRaces;
	}
	public List<Bet> getAllBets() {
		return allBets;
	}
	public void setAllBets(List<Bet> allBets) {
		this.allBets = allBets;
	}
	
	

}
