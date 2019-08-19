package com.hackerrank.warmup;

import java.util.Scanner;

public class Time_Conversion {
	static String timeConversion(String s) {
		// Complete this function
		String result = null;
		String[] time = s.split(":");
		time[2] = s.substring(s.lastIndexOf(':') + 1, s.lastIndexOf(':') + 3);

		int newHour;
		if (Integer.parseInt(time[0]) == 12) {
			newHour = 0;
		} else {
			newHour = Integer.parseInt(time[0]);
		}

		int shift;
		if (s.toLowerCase().contains("pm")) {
			shift = 12;
		} else {
			shift = 0;
		}

		result = (String.format("%02d:%02d:%02d", (newHour + shift), Integer.parseInt(time[1]),
				Integer.parseInt(time[2])));
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		String result = timeConversion(s);
		System.out.println(result);
		in.close();
	}
}
