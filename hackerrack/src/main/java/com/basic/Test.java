package com.basic;

//import java.time.LocalDateTime;
import java.time.Month;

public class Test {

	// Java8StreamReadFile streamRead = new Java8StreamReadFile();
	// streamRead.bufferRead("/Users/nandithamurthy/Downloads/test.txt");

	public static void main(String[] args) {

		// 1. get the fileName
		//String fileName = "data/test.txt";

		//If each line as one entry and if you want to collect it in a list for Strings
		//Java8StreamReadFile.readEachLineAsListOfStrings(fileName);
			
		//If there are only one number in each line in a file read them as integers
		//Java8StreamReadFile.readEachLineMapAsIntegersUsingBufferdRead(fileName);

		
		//String fileName2 = "data/test2.txt";
		//Java8StreamReadFile.testSomething(fileName2);
		
		
		//ScanInput.fizzBuzz(fileName2);
		
		@SuppressWarnings("unused")
		String inputFileName = "data/input.csv";
		@SuppressWarnings("unused")
		String outputFileName = "data/output.csv";
		//Java8StreamReadFile.replaceTabWithComma(inputFileName, outputFileName);
		
		//Java8StreamReadFile.readCsvFileFormatDateColumn(inputFileName, outputFileName);
		

		// Test dateTime or Time, Date, Month, year
		//System.out.println("get Current Zoned Date Time" + " --> " + DateHandlerUtility.getCurrentZonedDateTime());
		//System.out.println(DateHandlerUtility.getZoneInfoOnly()); 
		
//		System.out.println("get Current Date using zonedDateTime" + " --> " + DateHandlerUtility.getCurrentDateOnly2());
//		System.out.println("get Current Month using zonedDateTime" + "-->" + DateHandlerUtility.getCurrentMonthOnly2());
//		System.out.println("get Current year using zonedDateTime" + "-->" + DateHandlerUtility.getCurrentYearOnly2()); 
//		System.out.println("get day of Month using zonedDateTime" + "-->" +DateHandlerUtility.getDayOfMonth2());
//		System.out.println("get Current hour using zonedDateTime" + "-->" + DateHandlerUtility.getCurrentHour2()); 
//		System.out.println("get Current minute using zonedDateTime" + "-->" + DateHandlerUtility.getCurrentMinute2()); 
//		System.out.println("get Current second using zonedDateTime" + "-->" + DateHandlerUtility.getCurrentSecond2()); 
				
		//System.out.println( "get Current Time using LocalTime" + "---> "+DateHandlerUtility.getCurrentTimeOnly());
		
		//System.out.println("get Current Time" + "-->" + DateHandlerUtility.getCurrentDateTime());
		
		//System.out.println("get Current Date using LocalDateTime" + "-->" + DateHandlerUtility.getCurrentDateOnly());
		//System.out.println("get Current Month using LocalDateTime" + "-->" + DateHandlerUtility.getCurrentMonthOnly());
		//System.out.println("get Current year using LocalDateTime" + "-->" + DateHandlerUtility.getCurrentYearOnly()); 
		//System.out.println("get day of Month using LocalDateTime" + "-->" +DateHandlerUtility.getDayOfMonth());
		//System.out.println("get Current hour using LocalDateTime" + "-->" + DateHandlerUtility.getCurrentHour()); 
		//System.out.println("get Current minute using LocalDateTime" + "-->" + DateHandlerUtility.getCurrentMinute()); 
		//System.out.println("get Current second using LocalDateTime" + "-->" + DateHandlerUtility.getCurrentSecond()); 
		
		
		//Test Date Format converts
//		System.out.println( "2015-11-18" + "---> "+DateHandlerUtility.dateFormat_ISO_LOCAL_DATE("2015-11-18"));
//		System.out.println( "18/11/2015" + "---> "+DateHandlerUtility.dateTimeFormat_FromUserFormatterToISO_LOCAL_DATE("18/11/2015", "dd/MM/yyyy"));
//		System.out.println( "18 Nov 2018" + "---> "+DateHandlerUtility.dateTimeFormat_FromUserFormatterToISO_LOCAL_DATE("18 Nov 2018", "dd MMM yyyy"));
//	
//		System.out.println( "18/11/2015" + "---> "+DateHandlerUtility.dateTimeFormat_FromUserFormatterToUserFormat("18/11/2015", "dd/MM/yyyy", "dd MMM yyyy"));
//		System.out.println( "18 Nov 2018" + "---> "+DateHandlerUtility.dateTimeFormat_FromUserFormatterToUserFormat("18 Nov 2018", "dd MMM yyyy", "dd/MM/yyyy"));
//		System.out.println( "Fri Jul 06 05:30:00 IST 2018" + "---> "+DateHandlerUtility.dateTimeFormat_FromUserFormatterToUserFormat("Fri Jul 06 05:30:00 IST 2018", "E MMM d H:m:s z yyyy", "dd/MM/yyyy"));
//	
//		System.out.println( "03, 2018, Month.JANUARY" + "---> "+DateHandlerUtility.createDateWithData(03, 2018, Month.JANUARY));
//		System.out.println( "2h 30m" + "---> "+DateHandlerUtility.createTimeWithData(2,30));
//		System.out.println( "AM(2h 30m 30s)" + "---> "+DateHandlerUtility.createTimeWithData(2,30,30));
//		System.out.println( "PM(15h, 30m, 28m)" + "---> "+DateHandlerUtility.createTimeWithData(15, 30, 28));
		System.out.println( "10day, 2015Y, Month.APRIL, 2H, 10M" + "---> "+DateHandlerUtility.createDateTimeWithData(10, 2015, Month.APRIL, 2, 10));
		
		//System.out.println( "Date on 100th of 2018" + "---> "+DateHandlerUtility.getDateForGivenYearAndNthDay(100, 2018));
		//System.out.println( "Time on 10160th of second" + "---> "+DateHandlerUtility.getTimeForGivenNoOfSeconds(10160));
		
		
		
	}
}
