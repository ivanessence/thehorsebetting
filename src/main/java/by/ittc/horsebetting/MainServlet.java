package by.ittc.horsebetting;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.ittc.horsebetting.command.CommandFactory;
import by.ittc.horsebetting.command.ICommand;

public class MainServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");

		ICommand command = CommandFactory.getCommand(action);

		if (command != null) {
			String page = command.execute(request, response);

			if (page != null) {
				request.getRequestDispatcher("WEB-INF/pages/" + page + ".jsp")
						.forward(request, response);
				
			}
		}
	}

}
