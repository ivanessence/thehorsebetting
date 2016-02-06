package by.ittc.horsebetting.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import by.ittc.horsebetting.dao.HibernateEater;
import by.ittc.horsebetting.dao.INewsDAO;
import by.ittc.horsebetting.model.News;

public class NewsDAO extends AbstractDAO implements INewsDAO {

	@Override
	public void saveOrUpdateNews(News news) {
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		Session session = null;
		try {
			connection = dataSource.getConnection();
			if (news.getId() != 0) {
				session = HibernateEater.getSessionFactory()
						.getCurrentSession();
				session.beginTransaction();
				session.update(news);
				session.getTransaction().commit();
				
			} else {
				session = HibernateEater.getSessionFactory()
						.getCurrentSession();
				session.beginTransaction();
				session.save(news);
				session.getTransaction().commit();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (HibernateEater.getSessionFactory() != null) {

				try {
					HibernateEater.getSessionFactory().close();
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Session isn't close");
				}
			}

			close(connection, resultSet, preparedStatement);
		}

	}

	@Override
	public List<News> getAllNews() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<News> newsList = new ArrayList<News>();
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection
					.prepareStatement("SELECT id, title, text FROM news");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				News news = new News();
				news.setId(resultSet.getInt(1));
				news.setTitle(resultSet.getString(2));
				news.setText(resultSet.getString(3));
				newsList.add(news);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement, resultSet);
		}
		return newsList;
	}

}
