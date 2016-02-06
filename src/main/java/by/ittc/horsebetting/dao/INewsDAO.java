package by.ittc.horsebetting.dao;

import java.util.List;

import by.ittc.horsebetting.model.News;

public interface INewsDAO {

	void saveOrUpdateNews(News news);

	List<News> getAllNews();

}
