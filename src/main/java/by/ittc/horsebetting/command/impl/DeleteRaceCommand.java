package by.ittc.horsebetting.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.ittc.horsebetting.command.ICommand;
import by.ittc.horsebetting.dao.BeanFacade;
import by.ittc.horsebetting.dao.IRaceDAO;

public class DeleteRaceCommand implements ICommand {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Integer id = new Integer(request.getParameter("id"));

		IRaceDAO raceDAO = BeanFacade.getRaceDAO();
		raceDAO.deleteOrReturnRace(id, 1);

		return "adminPanel";
	}

}
