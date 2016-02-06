package by.ittc.horsebetting.dao;

import java.util.List;

import by.ittc.horsebetting.model.Race;

public interface IRaceSort {

	void sortRaceByDate(List<Race> races);

	void sortRaceByDestination(List<Race> races);

	void sortRaceByHorse(List<Race> races);

	void sortRaceByStatus(List<Race> races);
}
