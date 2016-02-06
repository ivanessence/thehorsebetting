package by.ittc.horsebetting.command;

import java.util.List;

import by.ittc.horsebetting.methods.SortMethod;
import by.ittc.horsebetting.model.Race;

public class SortingUtill {

	public static void findFilter(String filter, List<Race> races) {
		SortMethod method = new SortMethod();
		if (filter != null && !filter.isEmpty()) {
			switch (filter) {
			case "Date":
				method.sortRaceByDate(races);
				break;
			case "Destination":
				method.sortRaceByDestination(races);
				break;
			case "Horse":
				method.sortRaceByHorse(races);
				break;
			case "Status":
				method.sortRaceByStatus(races);
			}
		}

	}
}
