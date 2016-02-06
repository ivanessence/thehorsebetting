package by.ittc.horsebetting.model;

import java.util.List;

public class Bookie extends User {
	
	private final static String access = "bookie";
	private List<Bet> allBets;
	private List<Race> allRaces;
	
	
	
	public Bookie() {
		super();
	}
	
	public String getAccess() {
		return access;
	}
	
	public List<Bet> getAllBets() {
		return allBets;
	}
	public void setAllBets(List<Bet> allBets) {
		this.allBets = allBets;
	}
	public List<Race> getAllRaces() {
		return allRaces;
	}
	public void setAllRaces(List<Race> allRaces) {
		this.allRaces = allRaces;
	}
	
	
	

}
