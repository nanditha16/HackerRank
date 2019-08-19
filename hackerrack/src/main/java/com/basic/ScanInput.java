package com.basic;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class ScanInput {

	
	public static void scanInputValues(String fileName) {

		try (Scanner scanner = new Scanner(new File(fileName))) {

			while (scanner.hasNext()){
				System.out.println(scanner.nextLine());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/*
	 * 
	 * Write a program that prints the numbers in the given range. 
	 * But for multiples of three print “Fizz” instead of the number 
	 * and for the multiples of five print “Buzz”. 
	 * 
	 * For numbers which are multiples of both three and five print “FizzBuzz”. 
	 * Print a new line after each string or number.
	 * 
	 * Input Format First line will be the number of testcases, T. 
	 * Next line will have T integers, denoted by N.
	 * 
	 * Output Format For each testcase, 
	 * print the number from 1 to N. 
	 * But follow the rules given in the problem statement.
	 * 
	 * Constraints
	 * 1 <= T <= 10
	 * N is an integer.
	 * 
	 */
	
	public static void fizzBuzz(String fileName) {
		try {
			// Read all the lines to get T and testcases
			Scanner scanner = new Scanner(new File(fileName));
			int T = scanner.nextInt();
			int testcase;

			for (int i = 0; i < T; i++) {
				testcase = scanner.nextInt();
				for (int j = 1; j <= testcase; j++) {
					if ((j % 3 == 0) && (j % 5 == 0)) {
						System.out.println("FizzBuzz");
					} else if (j % 3 == 0) {
						System.out.println("Fizz");
					} else if (j % 5 == 0) {
						System.out.println("Buzz");
					} else {
						System.out.println(j);
					}
				}

			}
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
