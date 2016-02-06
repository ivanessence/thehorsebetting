package by.ittc.horsebetting.model;

import java.util.List;

public class Client extends User {

	private final static String access = "Client";
	private List<Bet> myBets;
	private long money;

	public Client() {
		super();
	}

	public String getAccess() {
		return access;
	}

	public List<Bet> getMyBets() {
		return myBets;
	}

	public void setMyBets(List<Bet> myBets) {
		this.myBets = myBets;
	}

	public long getMoney() {
		return money;
	}

	public void setMoney(long money) {
		this.money = money;
	}

}
