package com.basic;

import java.util.Arrays;

public class StringHandlerUtility {

	public static int findIndexOfGivenFieldInString(String fieldName, String strContainingFields) {
			return Arrays.asList(strContainingFields.split(",")).indexOf(fieldName);
	}
	
	public static String findFieldFromGivenIndexinString(int index, String strContainingFields) {
		return Arrays.asList(strContainingFields.split(",")).get(index);
}
}
