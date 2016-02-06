package by.ittc.horsebetting.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.ittc.horsebetting.command.ICommand;
import by.ittc.horsebetting.dao.BeanFacade;
import by.ittc.horsebetting.dao.IRaceDAO;
import by.ittc.horsebetting.model.Race;

public class ConfirmAddRaceCommand implements ICommand {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int i = 0;
		String koef = new String();
		String horses = new String();
		while (request.getParameter("koef" + i) != null) {

			koef += request.getParameter("koef" + i) + " ";
			i++;
		}
		i = 0;
		while (request.getParameter("horse" + i) != null) {
			horses += request.getParameter("horse" + i) + " ";
			i++;
		}

		Race race = new Race();
		race.setCoefficients(koef);
		race.setHorsesId(horses);
		race.setDate(request.getParameter("calendar"));
		Float destination = new Float(request.getParameter("destination"));
		race.setDestination(destination);

		IRaceDAO iRaceDAO = BeanFacade.getRaceDAO();
		iRaceDAO.saveOrUpdateRace(race);

		return "adminPanel";
	}
}
