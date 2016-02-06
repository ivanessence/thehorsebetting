package by.ittc.horsebetting.methods;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateMethod {

	
	public static String formatDate(String oldDate) throws ParseException
	{
		
	        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
	        Date dateStr = formatter.parse(oldDate);
	        String formattedDate = formatter.format(dateStr);
	        
	        
		return formattedDate;
	}
}
