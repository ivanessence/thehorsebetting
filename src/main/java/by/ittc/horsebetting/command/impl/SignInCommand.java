package by.ittc.horsebetting.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.ittc.horsebetting.command.ICommand;
import by.ittc.horsebetting.dao.BeanFacade;
import by.ittc.horsebetting.dao.IUserDAO;
import by.ittc.horsebetting.model.Administrator;
import by.ittc.horsebetting.model.Client;
import by.ittc.horsebetting.model.User;

public class SignInCommand implements ICommand {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter("login");
		String password = request.getParameter("password");

		IUserDAO userDAO = BeanFacade.getUserDAO();
		User user = userDAO.login(login, password);
		String page = "theHorseBetting";

		if (user != null) {
			if (user instanceof Administrator) {
				page = "adminPanel";

			} else if (user instanceof Client) {
				page = "clientPage";
			}
		} else {
			request.getSession().setAttribute("signInError", "error");
		}

		request.getSession().setAttribute("user", user);
		return page;
	}

}
