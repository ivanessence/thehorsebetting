package by.ittc.horsebetting.dao;

import java.util.List;

import by.ittc.horsebetting.model.Race;

public interface IRaceDAO {

	List<Race> getAllActiveRace();

	List<Race> getAllDeletedRace();

	Race getRace(Integer id);

	void saveOrUpdateRace(Race race);

	void setWinnerHorse(Integer id, String name);
	
	void deleteOrReturnRace(Integer id, Integer deleted);
}
