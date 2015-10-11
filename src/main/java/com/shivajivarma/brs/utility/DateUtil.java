package com.shivajivarma.brs.utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author <a href="http://shivajivarma.com" target="_blank">Shivaji Varma</a>
 */
public class DateUtil {
	
	public static final int maxDaysOfAMonth(int year,int month){
		Calendar calendar=Calendar.getInstance();
		calendar.set(year, month-1, 1);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	public static final int currentYear(){
		return Integer.parseInt(new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime()));
	}
	
	public static final int currentMonth(){
		return Integer.parseInt(new SimpleDateFormat("MM").format(Calendar.getInstance().getTime()));
	}
	
	public static final int currentDay(){
		return Integer.parseInt(new SimpleDateFormat("dd").format(Calendar.getInstance().getTime()));
	}
	
	public static final String currentDate(){
		return new SimpleDateFormat("dd/MMM/yyyy").format(Calendar.getInstance().getTime());
	}
	
	public static final String getTimeStamp(){
		return new SimpleDateFormat("dd/MMM/yyyy").format(Calendar.getInstance().getTime());
	}
}
