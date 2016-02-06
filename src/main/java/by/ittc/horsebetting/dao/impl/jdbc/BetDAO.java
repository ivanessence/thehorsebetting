package by.ittc.horsebetting.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.ittc.horsebetting.dao.IBetDao;
import by.ittc.horsebetting.model.Bet;
import by.ittc.horsebetting.model.Race;

public class BetDAO extends AbstractDAO implements IBetDao {

	@Override
	public void saveBet(Bet bet) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement("insert into bets (amount, raceID, horseID, userID, status, coefficent) values (?,?,?,?,?,?)");
			
			preparedStatement.setFloat(1, bet.getAmount());
			preparedStatement.setInt(2, bet.getRaceID());
			preparedStatement.setInt(3, bet.getHorseID());
			preparedStatement.setInt(4, bet.getUserID());
			preparedStatement.setInt(5, bet.getStatus());
			preparedStatement.setFloat(6, bet.getCoefficent());
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, preparedStatement);
		}
	}
	@Override
	public void deleteBet(Bet bet) {
		// TODO Auto-generated method stub

	}

}
