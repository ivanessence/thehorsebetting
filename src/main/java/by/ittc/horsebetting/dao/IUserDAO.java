package by.ittc.horsebetting.dao;

import java.util.List;

import by.ittc.horsebetting.model.Bet;
import by.ittc.horsebetting.model.User;

public interface IUserDAO {

	User login(String login, String password);

	User getUser(Integer id);

	List<User> loadAllOkUsers();

	List<User> loadAllDeletedUsers();

	void saveOrUpdateUser(User user);

	List<Bet> getAllByClient(Integer id);

	void deleteOrReturnUser(Integer id, Integer deleted);

}
