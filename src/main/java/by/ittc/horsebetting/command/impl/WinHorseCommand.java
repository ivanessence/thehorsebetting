package by.ittc.horsebetting.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.ittc.horsebetting.command.ICommand;
import by.ittc.horsebetting.dao.BeanFacade;
import by.ittc.horsebetting.dao.IRaceDAO;

public class WinHorseCommand implements ICommand {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Integer idRace = new Integer(request.getParameter("id"));
		String name = request.getParameter("name");

		IRaceDAO raceDAO = BeanFacade.getRaceDAO();
		raceDAO.setWinnerHorse(idRace, name);

		return "adminPanel";
	}

}
