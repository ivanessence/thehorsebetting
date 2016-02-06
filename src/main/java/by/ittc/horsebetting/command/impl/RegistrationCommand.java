package by.ittc.horsebetting.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.ittc.horsebetting.command.ICommand;
import by.ittc.horsebetting.dao.BeanFacade;
import by.ittc.horsebetting.dao.IUserDAO;
import by.ittc.horsebetting.model.Client;
//import by.ittc.horsebetting.methods.EditUserMethod;
//import by.ittc.horsebetting.model.UserTemp;

public class RegistrationCommand implements ICommand {

	
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String mail = request.getParameter("email");
		String name = request.getParameter("name");
		String lastName = request.getParameter("lastname");
		String telephone = request.getParameter("telephone");

		Client client = new Client();
		client.setLogin(login);
		client.setPassword(password);
		client.setMail(mail);
		client.setName(name);
		client.setLastName(lastName);
		client.setTelephone(telephone);
		
		IUserDAO userDAO = BeanFacade.getUserDAO();
		userDAO.saveOrUpdateUser(client);

		return "accessReg";
	}

}
