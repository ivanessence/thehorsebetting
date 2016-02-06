package by.ittc.horsebetting.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import by.ittc.horsebetting.dao.IRaceDAO;
import by.ittc.horsebetting.model.Race;

public class RaceDAO extends AbstractDAO implements IRaceDAO {
	private static final String GET_ALL_RACES_SQL = "SELECT id, destination, date, horses, status, koef, deleted FROM races";

	@Override
	public List<Race> getAllActiveRace() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Race> races = new ArrayList<Race>();
		List<String> horses = getAllHorses();
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(GET_ALL_RACES_SQL
					+ " WHERE deleted=?");
			preparedStatement.setInt(1, 0);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Race race = initRace(resultSet, horses);
				races.add(race);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement, resultSet);
		}
		return races;

	}

	public List<Race> getAllDeletedRace() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Race> races = new ArrayList<Race>();
		List<String> horses = getAllHorses();

		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(GET_ALL_RACES_SQL
					+ " WHERE deleted=1");

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Race race = initRace(resultSet, horses);
				races.add(race);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement, resultSet);
		}
		return races;
	}

	private Race initRace(ResultSet resultSet, List<String> horses)
			throws SQLException {
		Race race = new Race();
		race.setId(resultSet.getInt(1));
		race.setDestination(resultSet.getFloat(2));
		race.setDate(resultSet.getString(3));
		race.setHorsesNames(initNameOfHorses(resultSet.getString(4), horses));
		race.setStatus(resultSet.getString(5));
		race.setCoefficients(resultSet.getString(6));
		return race;
	}

	@Override
	public Race getRace(Integer id) {
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		Race race = null;
		List<String> horses = getAllHorses();
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(GET_ALL_RACES_SQL
					+ " WHERE id=?");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				race = initRace(resultSet, horses);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return race;
	}

	@Override
	public void saveOrUpdateRace(Race race) {
		Connection connection = null;

		PreparedStatement preparedStatement = null;

		try {
			connection = dataSource.getConnection();
			if (race.getId() != 0) {
				preparedStatement = connection
						.prepareStatement("UPDATE races SET destination=?, date=?, horses=?,"
								+ " status=?, koef=? WHERE id=?");
				initPreparedStatement(race, preparedStatement);
				preparedStatement.setInt(6, race.getId());
				preparedStatement.executeUpdate();
			} else {
				preparedStatement = connection
						.prepareStatement("INSERT INTO races (destination, date, horses, status, koef) VALUES (?,?,?,?,?)");
				initPreparedStatement(race, preparedStatement);
				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement);
		}
	}

	private void initPreparedStatement(Race race,
			PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setFloat(1, race.getDestination());
		preparedStatement.setString(2, race.getDate());
		preparedStatement.setString(3, race.getHorsesId());
		preparedStatement.setString(4, race.getStatus());
		preparedStatement.setString(5, race.getCoefficients());
	}

	public static List<String> initNameOfHorses(String horses,
			List<String> nameOfHorses) {

		StringTokenizer str = new StringTokenizer(horses);
		String string = new String();
		List<Integer> listHorses = new ArrayList<>();
		List<String> listOfHorses = new ArrayList<>();

		while (str.hasMoreTokens()) {
			string += str.nextToken();

			Integer temp = new Integer((string.charAt(string.length() - 1)));

			temp -= 49;

			listHorses.add(temp);
		}

		for (int i = 0; i < listHorses.size(); i++) {

			listOfHorses.add(nameOfHorses.get(listHorses.get(i)));

		}

		return listOfHorses;
	}

	private List<String> getAllHorses() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<String> horses = new ArrayList<String>();
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection
					.prepareStatement("SELECT name FROM horses");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				horses.add(resultSet.getString(1));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, resultSet, preparedStatement);
		}
		return horses;
	}

	@Override
	public void setWinnerHorse(Integer id, String name) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection
					.prepareStatement("UPDATE races SET nameWinnerHorse=? WHERE id=?");

			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement);
		}
	}

	@Override
	public void deleteOrReturnRace(Integer id, Integer deleted) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Date toDay = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		String date = dateFormat.format(toDay);

		try {
			connection = dataSource.getConnection();
			preparedStatement = connection
					.prepareStatement("UPDATE races SET deleted=?, deletedDate=? WHERE id=?");
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
}
