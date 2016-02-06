package by.ittc.horsebetting.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import by.ittc.horsebetting.dao.IUserDAO;
import by.ittc.horsebetting.model.Administrator;
import by.ittc.horsebetting.model.Bet;
import by.ittc.horsebetting.model.Client;
import by.ittc.horsebetting.model.User;

public class UserDAO extends AbstractDAO implements IUserDAO {

	private static final String GET_ALL_CLIENTS_SQL = "select id, login, password, balance, name, lastname, "
			+ "email, telephone, access, deleted FROM users";

	public User login(String login, String password) {
		User user = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = dataSource.getConnection();

			preparedStatement = connection.prepareStatement(GET_ALL_CLIENTS_SQL
					+ " WHERE login = ? and password = ?");
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, password);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				user = initUser(resultSet);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(resultSet, preparedStatement, connection);
		}

		return user;
	}

	private User initUser(ResultSet resultSet) throws SQLException {
		if ("Client".equals(resultSet.getString(9))) {
			Client client = new Client();
			client.setId(resultSet.getInt(1));
			client.setLogin(resultSet.getString(2));
			client.setPassword(resultSet.getString(3));
			client.setBalance(resultSet.getFloat(4));
			client.setName(resultSet.getString(5));
			client.setLastName(resultSet.getString(6));
			client.setMail(resultSet.getString(7));
			client.setTelephone(resultSet.getString(8));
			return client;
		} else {
			Administrator admin = new Administrator();
			admin.setId(resultSet.getInt(1));
			admin.setLogin(resultSet.getString(2));
			admin.setPassword(resultSet.getString(3));
			admin.setBalance(resultSet.getFloat(4));
			admin.setName(resultSet.getString(5));
			admin.setLastName(resultSet.getString(6));
			admin.setMail(resultSet.getString(7));
			admin.setTelephone(resultSet.getString(8));
			return admin;
		}
	}

	@Override
	public List<User> loadAllOkUsers() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<User> users = new ArrayList<User>();
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection
					.prepareStatement(GET_ALL_CLIENTS_SQL+" WHERE deleted=0");
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				if (initUser(resultSet) != null) {
					users.add(initUser(resultSet));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(resultSet, preparedStatement, connection);
		}

		return users;
	}

	@Override
	public void saveOrUpdateUser(User user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			if (user.getId() != 0) {
				preparedStatement = connection
						.prepareStatement("UPDATE users SET login=?"
								+ " , password=?, email=?"
								+ " , name=?, lastname=?"
								+ " ,  balance=?, telephone=?, access=? WHERE id=?");
				addPreparedStatement(user, preparedStatement);

				preparedStatement.setInt(9, user.getId());
				preparedStatement.executeUpdate();
			} else {
				preparedStatement = connection
						.prepareStatement("INSERT INTO users (login, password, email, name, lastname, balance, telephone, access) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
				addPreparedStatement(user, preparedStatement);
				preparedStatement.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement);
		}

	}

	private void addPreparedStatement(User user,
			PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setString(1, user.getLogin());
		preparedStatement.setString(2, user.getPassword());
		preparedStatement.setString(3, user.getMail());
		preparedStatement.setString(4, user.getName());
		preparedStatement.setString(5, user.getLastName());
		preparedStatement.setFloat(6, user.getBalance());
		preparedStatement.setString(7, user.getTelephone());
		preparedStatement.setString(8, user.getAccess());

	}

	@Override
	public User getUser(Integer id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User user = null;

		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(GET_ALL_CLIENTS_SQL
					+ " WHERE id=?");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				user = initUser(resultSet);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement, resultSet);
		}
		return user;
	}

	public List<Bet> getAllByClient(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrReturnUser(Integer id, Integer deleted) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Date toDay = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		String date = dateFormat.format(toDay);
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection
					.prepareStatement("UPDATE users SET deleted=?, deletedDate=? WHERE id=?");
			preparedStatement.setInt(1, deleted);
			preparedStatement.setString(2, date);
			preparedStatement.setInt(3, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement);
		}

	}

	@Override
	public List<User> loadAllDeletedUsers() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<User> users = new ArrayList<User>();
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection
					.prepareStatement(GET_ALL_CLIENTS_SQL+" WHERE deleted=1");
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				if (initUser(resultSet) != null) {
					users.add(initUser(resultSet));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(resultSet, preparedStatement, connection);
		}

		return users;
	}

}
