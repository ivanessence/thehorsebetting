package by.ittc.horsebetting.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.ittc.horsebetting.command.ICommand;
import by.ittc.horsebetting.model.Administrator;
import by.ittc.horsebetting.model.Client;
import by.ittc.horsebetting.model.User;

public class PageCommand implements ICommand {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String page = request.getParameter("page");

		User user = (User) request.getSession().getAttribute("user");

		if (user != null) {
			if (user instanceof Administrator) {

				if ("userList".equals(page)) {
					page = "userList";
				}
				if ("editUser".equals(page)) {
					page = "editUser";
				}
				if ("adminPanel".equals(page)) {
					page = "adminPanel";
				}
				if ("addRace".equals(page)) {
					page = "addRace";
				}
				if ("editNews".equals(page)) {
					page = "editNews";
				}
				if ("editRace".equals(page)) {
					page = "editRace";
				}
			} else if (user instanceof Client) {
				if ("changeData".equals(page)) {
					page = "changeData";
				}
				if ("clientPage".equals(page)) {
					page = "clientPage";
				}
				if ("myBet".equals(page)) {
					page = "myBet";
				}
				if ("myCabinet".equals(page)) {
					page = "myCabinet";
				}
				if ("myPurse".equals(page)) {
					page = "myPurse";
				}
				if ("newBet".equals(page)) {
					page = "newBet";
				}
			}
		} else {
			if ("howBegin".equals(page)) {
				page = "howBegin";
			}
			if ("news".equals(page)) {
				page = "news";
			}
			if ("registration".equals(page)) {
				page = "registration";
			}
			if ("rule".equals(page)) {
				page = "rule";
			}
			if ("type".equals(page)) {
				page = "type";
			}
		}

		return page;
	}
}
