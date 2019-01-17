package gregoriancalender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
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
	
	public static Date conversionToDateFromLocalDate(LocalDate localDate) {
		Date date = new Date();
		date = Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		return date;
	}
	
	public static String conversionToStringFromDate(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd"); 
		return formatter.format(date);
	}
	
	public static Date conversionToDateFromString(String string) throws ParseException {
		
		return new SimpleDateFormat("yyyy/MM/dd").parse(string);
	}
	
	
	public static LocalDate conversionToLocalDateFromString(String string) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/d");
        LocalDate localDate = LocalDate.parse(string , formatter);
        return localDate;
	}
	
	public static String conversionToStringFromLocalDate(LocalDate localDate) {
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/d");
		return localDate.format(formatter);
		
	}
	
	public static LocalDate conversionToLocalDateFromOffsetDate(OffsetDateTime offsetDateTime) {
		
		
		return offsetDateTime.withOffsetSameInstant(ZoneOffset.UTC).toLocalDate();
	}
	
	
	
	
	
	//new
	
	public static LocalDateTime conversionToLocalDateTimeFromDate(Date date) {
		
		 return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
		
	}
	
	 public static Date asDate(LocalDateTime localDateTime) {
		    
			
		  return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	  }
	

}
