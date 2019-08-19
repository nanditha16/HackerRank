package com.hackerrank.warmup;

import java.util.Scanner;

public class Staircase {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		int staircase = in.nextInt();

		for (int i = 0; i < staircase; i++) {
			for (int j = 1; j <= staircase; j++) {
				System.out.print(j < staircase - i ? " " : "#");
			}
			System.out.println();
		}
		in.close();
	}
}
