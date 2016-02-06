package by.ittc.horsebetting.command;

import by.ittc.horsebetting.command.impl.AddBetCommand;
import by.ittc.horsebetting.command.impl.AddNewsCommand;
import by.ittc.horsebetting.command.impl.ConfirmAddRaceCommand;
import by.ittc.horsebetting.command.impl.DeleteRaceCommand;
import by.ittc.horsebetting.command.impl.DeleteUserCommand;
import by.ittc.horsebetting.command.impl.EditNewsCommand;
import by.ittc.horsebetting.command.impl.EditUserCommand;
import by.ittc.horsebetting.command.impl.FilterRaceCommand;
import by.ittc.horsebetting.command.impl.PageCommand;
import by.ittc.horsebetting.command.impl.RegistrationCommand;
import by.ittc.horsebetting.command.impl.ReturnRaceCommand;
import by.ittc.horsebetting.command.impl.ReturnUserCommand;
import by.ittc.horsebetting.command.impl.SignInCommand;
import by.ittc.horsebetting.command.impl.SignOutCommand;
import by.ittc.horsebetting.command.impl.WinHorseCommand;

public abstract class CommandFactory {

	public static ICommand getCommand(String action) {

		if (action != null) {
			switch (action) {
			case "returnRace":
				return new ReturnRaceCommand();
			case "setWinnerHorse":
				return new WinHorseCommand();
			case "saveUser":
				return new EditUserCommand();
			case "returnUser":
				return new ReturnUserCommand();
			case "deleteUser":
				return new DeleteUserCommand();
			case "addNews":
				return new AddNewsCommand();
			case "signIn":
				return new SignInCommand();
			case "signOut":
				return new SignOutCommand();
			case "editUser":
				return new EditUserCommand();
			case "confirmAddRace":
				return new ConfirmAddRaceCommand();

			case "editNews":
				return new EditNewsCommand();

			case "deleteRace":
				return new DeleteRaceCommand();
			case "filterRace":
				return new FilterRaceCommand();
			case "addReg":
				return new RegistrationCommand();
			case "addBet":
				return new AddBetCommand();

			}
			return null;
		} else {
			return new PageCommand();
		}
	}

}
