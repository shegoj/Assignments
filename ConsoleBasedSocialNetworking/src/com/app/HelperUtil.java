package com.app;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HelperUtil {
	
public static String getCurrentTime () {
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	
	return dateFormat.format(date);
}

public static String formatMessageTime (String dateInString) {
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	Date messageTime = null;
	Date currentDate = new Date();
	
	String timeInString = null;
	
	try {
		messageTime = dateFormat.parse(dateInString);
		
		long diff = currentDate.getTime() - messageTime.getTime();
		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		
		if (diffHours != 0)
			timeInString = diffHours + " hours ago";
		
		else if (diffMinutes != 0)
			timeInString = diffMinutes + " minutes ago";
		
		else if (diffSeconds != 0)
			timeInString = diffSeconds + " seconds ago";
	}
	catch (ParseException ex) {
		ex.printStackTrace();
	}
	
	return timeInString;
}

public static void main (String args[]) {
	
	System.out.println(getCurrentTime());
	//System.out.println(messageTime("2014/02/09 14:05:10"));
	

}
}
