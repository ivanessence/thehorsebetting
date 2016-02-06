package by.ittc.horsebetting.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.ittc.horsebetting.command.ICommand;
import by.ittc.horsebetting.dao.BeanFacade;
import by.ittc.horsebetting.dao.INewsDAO;
import by.ittc.horsebetting.model.News;

public class EditNewsCommand implements ICommand {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String title = request.getParameter("title");
		String text = request.getParameter("text");
		Integer id = new Integer(request.getParameter("id"));

		News news = new News();
		news.setId(id);
		news.setTitle(title);
		news.setText(text);

		INewsDAO newsDAO = BeanFacade.getNewsDAO();
		newsDAO.saveOrUpdateNews(news);

		return "editNews";
	}
}
