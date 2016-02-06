package by.ittc.horsebetting.dao;

import by.ittc.horsebetting.model.Bet;

public interface IBetDao {

	void saveBet(Bet bet);
	void deleteBet(Bet bet);
	
}
