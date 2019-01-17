package gregoriancalender;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class ConversionTest {

	@Test
	public void testConversionToDateFromCalender() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		
		assertEquals( formatter.format(new Date()), formatter.format(Conversion.conversionToDateFromCalender(Calendar.getInstance())));
		assertNotNull(Conversion.conversionToDateFromCalender(Calendar.getInstance()));
	
	}

	@Test
	public void testConversionToLocalDateFromDate() {
		assertEquals(LocalDate.now(), Conversion.conversionToLocalDateFromDate(new Date()));
	}

	@Test
	public void testConversionToLocalDateFromCalender() {
		
		assertEquals(LocalDate.now(), Conversion.conversionToLocalDateFromCalender(Calendar.getInstance()));
		
	}

	@Test
	public void testConversionToDateFromLocalDate() {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		
		assertEquals(formatter.format(new Date()), formatter.format(Conversion.conversionToDateFromLocalDate(LocalDate.now())));
	}

	@Test
	public void testConversionToStringFromDate() {
		
		assertEquals("2019/01/17" , Conversion.conversionToStringFromDate(new Date()));
		
	}

	@Test
	public void testConversionToDateFromString() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		assertEquals(formatter.format(new Date()), formatter.format(Conversion.conversionToDateFromString("2019/01/17")));
	}

	@Test
	public void testConversionToLocalDateFromString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/d");
		//default, ISO_LOCAL_DATE
		LocalDate localDate = LocalDate.parse("2019/01/17" , formatter);
		assertEquals(localDate, Conversion.conversionToLocalDateFromString("2019/01/17"));
	
	}

	@Test
	public void testConversionToStringFromLocalDate() {
		assertEquals("2019/01/17", Conversion.conversionToStringFromLocalDate(LocalDate.now()));
	
	}

	@Test
	public void testConversionToLocalDateFromOffsetDate() {
		DateTimeFormatter fmt = new DateTimeFormatterBuilder()
			    .append(DateTimeFormatter.ISO_OFFSET_DATE)
			    .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
			    .toFormatter();
		assertEquals(LocalDate.now(), Conversion.conversionToLocalDateFromOffsetDate(OffsetDateTime.parse("2019-01-17-05:00", fmt)));
	}
	
	@Test
	public void testconversionToLocalDateTimeFromDate() {
		
		LocalDateTime localDateTime=Conversion.conversionToLocalDateTimeFromDate(new Date().from(Instant.now()));
		LocalDateTime expectedLocalDateTime=LocalDateTime.now();
		
		assertEquals(expectedLocalDateTime.now().getYear(),localDateTime.now().getYear());
		assertEquals(expectedLocalDateTime.now().getDayOfMonth(),localDateTime.now().getDayOfMonth());
		assertEquals(expectedLocalDateTime.now().getDayOfWeek(),localDateTime.now().getDayOfWeek());
		
	}
	
	@Test
	public void testconversionToDateFromLocalDateTime() {
		Date date=Conversion.asDate(LocalDateTime.now());
		Date dateExpected =new Date();
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss a");  
		String formattedDate = formatter.format(date);
		String formatedDateExpected=formatter.format(dateExpected);
		
		assertEquals(formatedDateExpected, formattedDate);
		
	}

}
