package by.ittc.horsebetting.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanFacade {

	
	private static final ApplicationContext CONTEXT = new ClassPathXmlApplicationContext(
			"spring-db.xml");

	public static IUserDAO getUserDAO() {
		return (IUserDAO) CONTEXT.getBean("userDAO");
	}

	
	public static IRaceDAO getRaceDAO() {

		return (IRaceDAO) CONTEXT.getBean("raceDAO");
	}

	public static INewsDAO getNewsDAO() {

		
		return (INewsDAO) CONTEXT.getBean("newsDAO");
		
	}
public static IBetDao getBetDAO() {

		
		return (IBetDao) CONTEXT.getBean("betDAO");
}
}
