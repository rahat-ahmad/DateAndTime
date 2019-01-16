package gregoriancalender;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;


public class ConversionTest {

	@Before
	public void beforeRunTheTest() {

	}

	@Test
	public void testConversionToDateFromCalender() {
		Calendar calender = Calendar.getInstance();
		Conversion conversion = new Conversion();
		Date date = new Date();
		Date testDate = new Date();
		date = conversion.conversionToDateFromCalender(calender);
	//	assertTrue(new Date().equals(new Conversion().conversionToDateFromCalender(calender)));
		assertEquals(testDate.toString() , date.toString());
		assertNotNull(date);
		//assertSame(new Date(), date);
		//assertTrue(testDate.equals(date));

	}

	@Test
	public void testConversionToLocalDateFromDate() {

		assertEquals(LocalDate.now(), new Conversion().conversionToLocalDateFromDate(new Date()));
		//assertNotEquals("16-01-2019", new Conversion().conversionToLocalDateFromDate(new Date()).toString());

	}

	@Test
	public void testConversionToLocalDateFromCalender() {
		assertEquals(LocalDate.now(), new Conversion().conversionToLocalDateFromCalender(Calendar.getInstance()));
	}

	@Test
	public void testConversionToDateFromLocalDate() {
//		System.out.println(new Conversion().conversionToDateFromLocalDate(LocalDate.now()).toString());
//		System.out.println(new Date().toString());
		assertEquals(new Date().toString(), new Conversion().conversionToDateFromLocalDate(LocalDate.now()).toString());
	}

	@Test
	public void testConversionToStringFromDate() {
		
		
	   // String strDate = formatter.format(date);  
		System.out.println(new Conversion().conversionToStringFromDate(new Date()));
		assertEquals("01/16/2019" , new Conversion().conversionToStringFromDate(new Date()));
	}

}
