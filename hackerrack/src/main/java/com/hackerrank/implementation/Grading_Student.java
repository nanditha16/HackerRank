package com.hackerrank.implementation;

import java.util.Scanner;

public class Grading_Student {
	static int[] solve(int[] grades) {
		// Complete this function
		int i = 0;
		for (int studgrade : grades) {
			if (studgrade >= 38) {
				if ((studgrade % 5) > 2) {
					studgrade = (((studgrade / 5) + 1) * 5);
				}
			}
			grades[i++] = studgrade;
			// System.out.println(studgrade);
		}
		return grades;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] grades = new int[n];
		for (int grades_i = 0; grades_i < n; grades_i++) {
			grades[grades_i] = in.nextInt();
		}
		int[] result = solve(grades);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
		}
		System.out.println("");
		in.close();
	}

}
