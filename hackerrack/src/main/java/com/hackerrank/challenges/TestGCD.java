package com.hackerrank.challenges;

import java.util.Arrays;

public class TestGCD {

	public static void main(String[] args) {
		int arr[] = {2,3,4,5,6};
		int n = arr.length;
		
		System.out.println(generalizedGCD(n, arr));
	}

	public static int generalizedGCD(int num, int[] arr) {
		/*
		 * reduction operations parallelize more gracefully,
		 * without needing additional synchronization and 
		 * with greatly reduce risk of data races.
		 */
		return Arrays.stream(arr).reduce((b,c) -> findGCD(b,c)).getAsInt();
	}

	private static int findGCD(int a, int b) {
		if(b == 0) {
			return a;
		}
		
		return findGCD(b, a%b);
	}

}
