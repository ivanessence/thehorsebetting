package by.ittc.horsebetting.methods;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import by.ittc.horsebetting.dao.IRaceSort;
import by.ittc.horsebetting.model.Race;

public class SortMethod implements IRaceSort {

	

	@Override
	public void sortRaceByDate(List<Race> races) {
		Collections.sort(races, new Comparator<Race>() {

			@Override
			public int compare(Race o1, Race o2) {
				
				return o1.getDate().compareTo(o2.getDate());
			}
		});
		
	}

	@Override
	public void sortRaceByDestination(List<Race> races) {
		Collections.sort(races, new Comparator<Race>() {

			@Override
			public int compare(Race o1, Race o2) {
				if (o1.getDestination() < o2.getDestination()) {

					return -1;
				} else if (o1.getDestination() > o2.getDestination()) {
					return 1;
				}

				return 0;

			}

		});
		
	}

	@Override
	public void sortRaceByHorse(List<Race> races) {
		// TODO Sort race by horse
		
	}

	@Override
	public void sortRaceByStatus(List<Race> races) {
		Collections.sort(races, new Comparator<Race>() {

			@Override
			public int compare(Race o1, Race o2) {
				return o1.getStatus().compareTo(o2.getStatus());
			}
		});
		
	}

}
