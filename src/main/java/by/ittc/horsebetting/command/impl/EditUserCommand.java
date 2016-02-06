package by.ittc.horsebetting.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.ittc.horsebetting.command.ICommand;
import by.ittc.horsebetting.dao.BeanFacade;
import by.ittc.horsebetting.dao.IUserDAO;
//import by.ittc.horsebetting.methods.EditUserMethod;
//import by.ittc.horsebetting.model.UserTemp;
import by.ittc.horsebetting.model.User;

public class EditUserCommand implements ICommand {

	@SuppressWarnings("null")
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		User user = null;
		if (request.getParameter("id") != null) {
			user.setId(new Integer(request.getParameter("id")));
		}
		user.setLogin(request.getParameter("login"));
		user.setPassword(request.getParameter("password"));
		user.setMail(request.getParameter("mail"));
		user.setName(request.getParameter("name"));
		user.setLastName(request.getParameter("lastName"));
		user.setAccess(request.getParameter("access"));
		user.setBalance(new Float(request.getParameter("balance")));
		user.setTelephone(request.getParameter("telephone"));

		IUserDAO userDAO = BeanFacade.getUserDAO();
		userDAO.saveOrUpdateUser(user);

		return "userList";
	}

}
