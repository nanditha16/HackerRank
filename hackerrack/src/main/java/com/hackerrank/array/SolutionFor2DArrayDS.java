package com.hackerrank.array;

import java.util.Scanner;

public class SolutionFor2DArrayDS {

	public static void main(String[] args) {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPATH_PATH")));
		Scanner scanner = new Scanner(System.in);

		int[][] arr = new int[6][6];

		// populate array
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 6; col++) {
				arr[row][col] = scanner.nextInt();
			}
		}

		/*
		 * Hour Glass Pattern 
		 * [col = 0][col = 1][col=2] 	//[row = 0] 
		 * 			[col = 1] 			//[row = 1] 
		 * [col = 0][col = 1][col=2] 	//[row = 2]
		 * 
		 */

		// To caluculate sum of hour glass - O(n^2)
		int result = hourglassSum(arr);
		System.out.println(result);
		scanner.close();

	}

	static int hourglassSum(int[][] arr) {

		int maxHourGlassSum = Integer.MIN_VALUE;
		int hourGlassSum;

		// To calculate sum of hour glass - O(n^2)
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
				hourGlassSum = arr[row][col] + arr[row][col + 1] + arr[row][col + 2]// [row 1]
						+ arr[row + 1][col + 1] // [row 2]
						+ arr[row + 2][col] + arr[row + 2][col + 1] + arr[row + 2][col + 2];// [row 3]
				maxHourGlassSum = Math.max(hourGlassSum, maxHourGlassSum);
			}
		}

		return maxHourGlassSum;
	}

}
