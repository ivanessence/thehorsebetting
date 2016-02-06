package by.ittc.horsebetting.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.ittc.horsebetting.command.ICommand;

public class FilterRaceCommand implements ICommand {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String page = "adminPanel";

		switch (request.getParameter("filter")) {
		case "Date":
			page += "?filter=Date";
			break;
		case "Destination":
			page += "?filter=Destination";
			break;
		case "Status":
			page += "?filter=Status";
			break;
		}

		return page;
	}

}
