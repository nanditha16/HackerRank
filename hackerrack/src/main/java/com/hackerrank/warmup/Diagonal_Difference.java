package com.hackerrank.warmup;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Diagonal_Difference {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		int rows = in.nextInt();
		in.nextLine();

		// save the values as int each row values
		int[][] arr = new int[rows][];
		for (int i = 0; i < rows; i++) {
			// String array from each line with " " as separator and save it as a List
			List<String> eachValList = Arrays.asList(in.nextLine().split(" "));

			// Convert List<String> to int[] and save each row values in arr[i]
			arr[i] = eachValList.stream().mapToInt(Integer::parseInt).toArray();
		}
		// To calculate sum of diagonal1
		int sumdiag1 = 0;
		for (int i = 0, j = 0; (i < rows && j < rows); i++, j++) {
			sumdiag1 += arr[i][j];
		}
		// System.out.println(sumdiag1);

		// To calculate sum of diagonal2
		int sumdiag2 = 0;
		for (int i = 0, j = rows - 1; (i < rows && j >= 0); i++, j--) {
			sumdiag2 += arr[i][j];
		}
		// System.out.println(sumdiag2);
		System.out.println(Math.abs(sumdiag1 - sumdiag2));
		
		in.close();
	}

}
