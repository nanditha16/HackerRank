package com.gson.sample;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		String _firstDate;
		String _lastDate;
		String _weekDay;
		
		try {
			_firstDate = in.nextLine();
			_lastDate = in.nextLine();
			_weekDay = in.nextLine();
			openAndClosePrices(_firstDate, _lastDate, _weekDay);
		} catch (Exception e) {
			_firstDate = null;
			_lastDate = null;
			_weekDay = null;
		} finally {
			in.close();
		}


		

	}

	private static void openAndClosePrices(String _firstDate, String _lastDate, String _weekDay) {
        URL url;
    try {

        String getDay = _weekDay.toUpperCase();
        int getDayValue = 0;
        switch (getDay) {
        case "MONDAY":
            getDayValue = 1;
            break;
        case "TUESDAY":
            getDayValue = 2;
            break;
        case "WEDNESDAY":
            getDayValue = 3;
            break;
        case "THURSDAY":
            getDayValue = 4;
            break;
        case "FRIDAY":
            getDayValue = 5;
            break;
        case "SATURDAY":
            getDayValue = 6;
            break;
        case "SUNDAY":
            getDayValue = 7;
            break;
        default:
            break;

        }
        
        for(int i = 1; i < 7; i++) {
            url = new URL("https://jsonmock.hackerrank.com/api/stocks/?page="+i);
            readFromURL(url, _firstDate, _lastDate, getDayValue);
            
        }
        
    } catch (MalformedURLException e) {
        e.printStackTrace();
    }

}


	private static void readFromURL(URL url, String _firstDate, String _lastDate, int getDayValue) {
			
		List<String> specifiedDateList = new ArrayList<String>();
		Gson gson = new Gson();
		InputStreamReader reader = null;

		try {
			reader = new InputStreamReader(url.openStream());
			JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

			JsonArray jsonArray = jsonObject.getAsJsonArray("data");
			Datum[] arrName = gson.fromJson(jsonArray, Datum[].class);

			List<Datum> lstName = new ArrayList<Datum>();
			lstName = Arrays.asList(arrName);

			specifiedDateList = getSpecifiedDayDatesFromTheDateRange(_firstDate, _lastDate, getDayValue);

			for (Datum str : lstName) {
				if (specifiedDateList.contains(str.getDate())) {
					System.out.println(str);
				}
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// from 1 (Monday) to 7 (Sunday).
	private static List<String> getSpecifiedDayDatesFromTheDateRange(String _firstDate, String _lastDate,
			int _weekDay) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMMM-yyyy");

		LocalDate startDate = LocalDate.parse(_firstDate, formatter);
		LocalDate endDate = LocalDate.parse(_lastDate, formatter);

		List<LocalDate> specifiedDaysDateList = new ArrayList<LocalDate>();
		List<String> specifiedDaysDateStringList = new ArrayList<String>();

		while (startDate.isBefore(endDate)) {
			if (startDate.getDayOfWeek() == DayOfWeek.of(_weekDay)) {
				specifiedDaysDateList.add(startDate);
				String strDate = formatter.format(startDate);
				specifiedDaysDateStringList.add(strDate);
			}
			startDate = startDate.plusDays(1);
		}

		return specifiedDaysDateStringList;
	}
}
