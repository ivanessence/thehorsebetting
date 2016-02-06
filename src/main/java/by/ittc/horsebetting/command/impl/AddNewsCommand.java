package by.ittc.horsebetting.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.ittc.horsebetting.command.ICommand;
import by.ittc.horsebetting.dao.BeanFacade;
import by.ittc.horsebetting.dao.INewsDAO;
import by.ittc.horsebetting.model.News;

public class AddNewsCommand implements ICommand {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String title = request.getParameter("title");
		String text = request.getParameter("text");
		News news = new News();
		news.setText(text);
		news.setTitle(title);

		INewsDAO newsDAO = BeanFacade.getNewsDAO();
		newsDAO.saveOrUpdateNews(news);

		return "adminPanel";
	}

}
