package com.basic;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateHandlerUtility {

	
	/*
	 * TO get current date and time with time zone
	 * 
	 */ 
	 // System.out.println(DateHandlerUtility.getCurrentZonedDateTime());  --> 2018-07-12T00:37:15.850+05:30[Asia/Kolkata]

	
	public static ZonedDateTime getCurrentZonedDateTime() {
		ZonedDateTime currZonedDateTime = ZonedDateTime.now();
		return currZonedDateTime;
		
	}
	
	/*
	 * TO get zone info alone 
	 * 
	 */ 
	 // System.out.println(DateHandlerUtility.getZoneInfoOnly()); --> Asia/Kolkata
	
	public static ZoneId getZoneInfoOnly() {
		ZoneId zone = ZonedDateTime.now().getZone();
		return zone;
		
	}
	
	/*
	 * TO get current date and time
	 * 
	 */ 
	 // System.out.println(DateHandlerUtility.getCurrentDateTime()); --> 2018-07-12T00:14:25.388
	
	public static LocalDateTime getCurrentDateTime() {
		LocalDateTime currTime = LocalDateTime.now();
		return currTime;
		
	}
	
	/*
	 * TO get current time alone using LocalTime
	 * 
	 */ 
	 // System.out.println(DateHandlerUtility.getCurrentTimeOnly()); -->  01:05:54.139
	
	public static LocalTime getCurrentTimeOnly() {
		LocalTime currTime = LocalTime.now();
		return currTime;
		
	}
	
	
	/*
	 * TO get current date alone using LocalDateTime
	 * 
	 */ 
	 // System.out.println(DateHandlerUtility.getCurrentDateOnly()); --> 2018-07-12
	
	public static LocalDate getCurrentDateOnly() {
		LocalDate currDate = LocalDateTime.now().toLocalDate();
		return currDate;
		
	}
	
	/*
	 * TO get current date alone using zoneDateTime
	 * 
	 */ 
	 // System.out.println(DateHandlerUtility.getCurrentDateOnly2()); --> 2018-07-12
	
	public static LocalDate getCurrentDateOnly2() {
		LocalDate currDate = ZonedDateTime.now().toLocalDate();
		return currDate;
		
	}
	
	
	/*
	 * TO get current year alone
	 * 
	 */ 
	 // System.out.println(DateHandlerUtility.getCurrentYearOnly()); --> 2018
	
	public static int getCurrentYearOnly() {
		int currYear = LocalDateTime.now().getYear();
		return currYear;
		
	}
	
	
	/*
	 * TO get current year alone using zoneDateTime
	 * 
	 */ 
	 // System.out.println(DateHandlerUtility.getCurrentYearOnly2()); --> 2018
	
	public static int getCurrentYearOnly2() {
		int currYear = ZonedDateTime.now().getYear();
		return currYear;
		
	}
	
	/*
	 * TO get current Month alone
	 * 
	 */ 
	 // System.out.println(DateHandlerUtility.getCurrentMonthOnly()); --> JULY
	
	public static Month getCurrentMonthOnly() {
		Month currMonth = LocalDateTime.now().getMonth();
		return currMonth;
		
	}
	
	/*
	 * TO get current Month alone using zoneDateTime
	 * 
	 */ 
	 // System.out.println(DateHandlerUtility.getCurrentMonthOnly2()); --> JULY
	
	public static Month getCurrentMonthOnly2() {
		Month currMonth = ZonedDateTime.now().getMonth();
		return currMonth;
		
	}
	
	/*
	 * TO get Day of Month alone
	 * 
	 */ 
	 // System.out.println(DateHandlerUtility.getDayOfMonth()); --> 12
	
	public static int getDayOfMonth() {
		int dayOfMonth = LocalDateTime.now().getDayOfMonth();
		return dayOfMonth;
		
	}
	
	/*
	 * TO get Day of Month alone using zoneDateTime
	 * 
	 */ 
	 // System.out.println(DateHandlerUtility.getDayOfMonth2()); --> 12
	
	public static int getDayOfMonth2() {
		int dayOfMonth = ZonedDateTime.now().getDayOfMonth();
		return dayOfMonth;
		
	}
	
	/*
	 * TO get current hour alone
	 * 
	 */ 
	 // System.out.println(DateHandlerUtility.getCurrentHour()); --> 0
	
	public static int getCurrentHour() {
		int currHour = LocalDateTime.now().getHour();
		return currHour;
		
	}
	
	/*
	 * TO get current hour alone using zoneDateTime
	 * 
	 */ 
	 // System.out.println(DateHandlerUtility.getCurrentHour2()); --> 0
	
	public static int getCurrentHour2() {
		int currHour = ZonedDateTime.now().getHour();
		return currHour;
		
	}
	
	/*
	 * TO get current minute alone
	 * 
	 */ 
	 // System.out.println(DateHandlerUtility.getCurrentMinute()); --> 32
	
	public static int getCurrentMinute() {
		int currMinute = LocalDateTime.now().getMinute();
		return currMinute;
		
	}
	
	/*
	 * TO get current minute alone using zoneDateTime
	 * 
	 */ 
	 // System.out.println(DateHandlerUtility.getCurrentMinute2()); --> 32
	
	public static int getCurrentMinute2() {
		int currMinute = ZonedDateTime.now().getMinute();
		return currMinute;
		
	}
	
	/*
	 * TO get current second alone
	 * 
	 */ 
	 // System.out.println(DateHandlerUtility.getCurrentSecond()); --> 10
	
	public static int getCurrentSecond() {
		int currSecond = LocalDateTime.now().getSecond();
		return currSecond;
		
	}
	
	/*
	 * TO get current second alone using zoneDateTime
	 * 
	 */ 
	 // System.out.println(DateHandlerUtility.getCurrentSecond2()); --> 10
	
	public static int getCurrentSecond2() {
		int currSecond = ZonedDateTime.now().getSecond();
		return currSecond;
		
	}
	
	//CREATE 
	/*
	 * create time object with values - hour and minute
	 * 	
	 */
	//System.out.println(DateHandlerUtility.createTimeWithData(2,30)); ---> 02:30
		
	public static LocalTime createTimeWithData(int hour, int minute) {
		LocalTime ttCreatedObj = LocalTime.of(hour, minute);
		return ttCreatedObj;
	}
		
	/*
	 * create time object with values - hour, seconds and minute
	 * 
	 */
	//System.out.println(DateHandlerUtility.createTimeWithData(2,30)); ---> 02:30:30
		
	public static LocalTime createTimeWithData(int hour, int minute, int seconds) {
		LocalTime ttCreatedObj = LocalTime.of(hour, minute, seconds);
		return ttCreatedObj;
	}	
		
	/*
	 * create date object with values
	 * 
	 */
	//System.out.println(DateHandlerUtility.createDateWithData(03, 2018, Month.JANUARY)); ---> 2018-01-03
		
	public static LocalDate createDateWithData(int date, int year, Month month) {
		LocalDate ddCreatedObj = LocalDate.of(year, month, date);
		return ddCreatedObj;
	}
		
	/*
	 * create dateTime object with values
	 * 
	 */
	//System.out.println(DateHandlerUtility.createDateTimeWithData(10, 2015, Month.APRIL, 2, 10)); ---> 2015-04-10T02:10
		
	public static LocalDateTime createDateTimeWithData(int dayOfMonth, int year, Month month, int hour, int minute) {
		LocalDateTime dtCreatedObj = LocalDateTime.of(year, month, dayOfMonth, hour, minute);
		return dtCreatedObj;
	}
	
	
	//Manipulations
	
	/*
	 * 
	 * get date on given year on 'n'th day
	 */
	//System.out.println(DateHandlerUtility.getDateForGivenYearAndNthDay(100, 2018)); ---> 2018-04-10
	
	public static LocalDate getDateForGivenYearAndNthDay(int dayOfYear, int year) {
		
		LocalDate randomDayDateObj = LocalDate.ofYearDay(year, dayOfYear);
		return randomDayDateObj;
	}
	
	 /*
	  *  converts no of seconds of the day to time
	  */
	//System.out.println( DateHandlerUtility.getTimeForGivenNoOfSeconds(10160)); ---> 02:49:20
	
	public static LocalTime getTimeForGivenNoOfSeconds(int noOfSeconds) {
		
		LocalTime randomSecondTimeObj = LocalTime.ofSecondOfDay(noOfSeconds);
		return randomSecondTimeObj;
	}
	
	//DATE 
	
	
	/*
	 * 
	 * "2015-11-18"
	 */
	// System.out.println(DateHandlerUtility.dateFormat_ISO_LOCAL_DATE("2015-11-18"));
	
	public static LocalDate dateFormat_ISO_LOCAL_DATE(String dateField) {
		LocalDate dtObj = LocalDate.parse(dateField);
		return dtObj;
	}
	
	/*
	 * Gives date in ISO_LOCAL_DATE format for a given user format
	 * "dd/MM/yyyy"
	 */
	//System.out.println(DateHandlerUtility.dateTimeFormat_UserFormatter("18/11/2015", "dd/MM/yyyy")); --> 2015-11-18
	//System.out.println(DateHandlerUtility.dateTimeFormat_UserFormatter("18 Nov 2018", "dd MMM yyyy")); --> 2018-11-18
	//System.out.println(DateHandlerUtility.dateTimeFormat_UserFormatter("Fri Jul 06 05:30:00 IST 2018", "E MMM d H:m:s z yyyy")); --> 2018-07-06

	public static LocalDate dateTimeFormat_FromUserFormatterToISO_LOCAL_DATE(String dateField, String formatter) {
		
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(formatter);
		LocalDate fdtObj = LocalDate.parse(dateField, dateFormatter);
		return fdtObj;
	}
	
	
	/*
	 * Gives date in user format change that String into another user format and return
	 * 
	 */
	//System.out.println(DateHandlerUtility.dateTimeFormat_FromUserFormatterToUserFormat("18/11/2015", "dd/MM/yyyy", "dd MMM yyyy")); --> 18 Nov 2015
	//System.out.println(DateHandlerUtility.dateTimeFormat_FromUserFormatterToUserFormat("18 Nov 2018", "dd MMM yyyy", "dd/MM/yyyy")); --> 18/11/2018
	//System.out.println(DateHandlerUtility.dateTimeFormat_FromUserFormatterToUserFormat("Fri Jul 06 05:30:00 IST 2018", "E MMM d H:m:s z yyyy", "dd/MM/yyyy")); --> 06/07/2018
	
	public static String dateTimeFormat_FromUserFormatterToUserFormat(String dateField, String fromFormatter, String toFormatter) {
		DateTimeFormatter fromDateFormatter = DateTimeFormatter.ofPattern(fromFormatter);
		DateTimeFormatter toDateFormatter = DateTimeFormatter.ofPattern(toFormatter);
		
		LocalDate fdtObj = LocalDate.parse(dateField, fromDateFormatter);
		String tdtObj = fdtObj.format(toDateFormatter);
		return tdtObj;
		
	}
	

}
