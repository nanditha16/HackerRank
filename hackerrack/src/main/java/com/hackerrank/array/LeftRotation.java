package com.hackerrank.array;

import java.util.Arrays;
import java.util.Scanner;

public class LeftRotation {

	/*
	 * The first line contains two space-separated integers n and d, 
	 * n = the size of a and 
	 * d = the number of left rotations you must perform. 
	 * 
	 * The second line contains n space-separated integers a[i].
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[] sizeAndShiftFactor = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
	    @SuppressWarnings("unused")
		int size = Integer.parseInt(sizeAndShiftFactor[0]);
	    int shiftFactor = Integer.parseInt(sizeAndShiftFactor[1]);
	
	    String[] arrItems = scanner.nextLine().split(" ");
       
        //int array of values
        int[] arr = Arrays.stream(arrItems).mapToInt(Integer::parseInt).toArray();
        
        int[] result = rotLeft(arr, shiftFactor);

		System.out.println(result);
		scanner.close();
	}


	/*
	 * Given an array arr of n integers and a number shiftFactor, 
	 * perform shiftFactor left rotations on the array. 
	 * 
	 * Return the updated array to be printed as a single line of space-separated integers.
	 */
	private static int[] rotLeft(int[] arr, int shiftFactor) {
		for(int i = 0; i < shiftFactor; i++) {
			int temp = arr[0];
			for(int j = 0; j < arr.length -1 ; j++) {
				arr[j] = arr[j+1];
			}
			arr[arr.length-1] = temp;
		}		
		return arr;
	}
}
