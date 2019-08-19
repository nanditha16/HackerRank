package com.hackerrank.warmup;

import java.util.Scanner;
import java.util.stream.Stream;

public class Plus_Minus {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		int totalnum = Integer.parseInt(in.nextLine());

		// String to string[] with " " as delimiter
		String[] val_s = in.nextLine().split(" ");

		// String[] to int[]
		int[] val_int = Stream.of(val_s).mapToInt(Integer::parseInt).toArray();

		double neg = 0, pos = 0, zer = 0;
		for (int i : val_int) {
			if (i < 0) {
				neg += 1;
			} else if (i > 0) {
				pos += 1;
			} else {
				zer += 1;
			}
		}
		System.out.println(pos / (double) totalnum);
		System.out.println(neg / (double) totalnum);
		System.out.println(zer / (double) totalnum);
		in.close();
	}
}
