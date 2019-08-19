package com.hackerrank.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumAbsoluteDifference {

	/*
	 * Given an array of integers, 
	 * find and print the minimum absolute difference between any two elements in the array. 
	 * 
	 * The first line contains a single integer n, the size of arr.  2 <= n <= 10^5
	 * The second line contains n space-separated integers.  -10^9 <= arr[i] <= 10^9
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		@SuppressWarnings("unused")
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
   
		 String[] arrItems = scanner.nextLine().split(" ");
	       
	     //int array of values
	     int[] arr = Arrays.stream(arrItems).mapToInt(Integer::parseInt).toArray();
	     
	     int result = minimumAbsoluteDifference(arr);

	     System.out.println(result);
	     scanner.close();
	}

	/*
	 * 
	 * n: an integer that represents the length of arr
	 * arr: an array of integers
	 * return an integer that represents the minimum absolute difference between any pair of elements.
	 */
	private static int minimumAbsoluteDifference(int[] arr) {
		// Step 1 Sort: O(nlogn) - Quicksort
		Arrays.sort(arr);
		
		//Step 2: Initialize diff to infinite
		int minimumDiff = Integer.MAX_VALUE;
		
		/* Greedy Algo : Check for minimum difference and update the minimumDiff value 
		 * by choosing the next value that offers the most obvious and immediate benefit. 
		 */
		for(int i = 0; i < arr.length-1 ; i++) {
			if((arr[i+1] - arr[i]) < minimumDiff) {
				minimumDiff = (arr[i+1] - arr[i]);
			}
			
		}
		return minimumDiff;
	}
}
