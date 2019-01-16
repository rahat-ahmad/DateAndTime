package gregoriancalender;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Conversion {
	
	
	public static Date conversionToDateFromCalender(Calendar calender) {
		Date date = new Date();
		date = calender.getTime();
		return date;
		
	}
	
	public static LocalDate conversionToLocalDateFromDate(Date date) {
		
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
	}
	
	public static LocalDate conversionToLocalDateFromCalender(Calendar calender) {
		return calender.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
	}
	
	@SuppressWarnings("deprecation")
	public static Date conversionToDateFromLocalDate(LocalDate localDate) {
		Date date = new Date();
		date = Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		//date.s
		date.setHours(new Date().getHours());
		date.setMinutes(new Date().getMinutes());
		date.setSeconds(new Date().getSeconds());
		return date;
	}
	
	public static String conversionToStringFromDate(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); 
		return formatter.format(date);
		
	}
	
	public static void main(String[] args) {
		
		Calendar calender = GregorianCalendar.getInstance();
		Conversion conversion = new Conversion();
		System.out.println(conversion.conversionToDateFromCalender(calender));
		System.out.println(conversion.conversionToLocalDateFromCalender(calender));
		System.out.println(conversion.conversionToDateFromLocalDate(LocalDate.now()));
		System.out.println(conversion.conversionToLocalDateFromDate(new Date()));
		System.out.println(conversion.conversionToStringFromDate(new Date()));
	}
	
	

}
