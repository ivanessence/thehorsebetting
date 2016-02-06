package by.ittc.horsebetting.model;

public class Bet {

	private Race race;
	private float coefficent;
	private float amount;
	private int raceID;
	private int horseID;
	private int userID;
	private int status;

	public Bet() {

	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public float getCoefficent() {
		return coefficent;
	}

	public void setCoefficent(float coefficent) {
		this.coefficent = coefficent;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public int getRaceID() {
		return raceID;
	}

	public void setRaceID(int raceID) {
		this.raceID = raceID;
	}

	public int getHorseID() {
		return horseID;
	}

	public void setHorseID(int horseID) {
		this.horseID = horseID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
