package com.hackerrank.string;

import java.util.Scanner;

public class AlternatingCharacters {

	/*
	 * You are given a string containing characters A  and B only. 
	 * change it into a string such that there are no matching adjacent characters.
	 * 
	 * The first line contains an integer q, the number of queries.  1 <= q <= 10
	 * The next q lines each contain a string .
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
   
		 for (int qItr = 0; qItr < q; qItr++) {
			 String s = scanner.nextLine();
			 int result = alternatingCharacters(s);
			 System.out.println(result);
		}
		 scanner.close();
	}


	/*
	 * Complete the alternatingCharacters 
	 * For each query, print the minimum number of deletions required on a new line.
	 */
	private static int alternatingCharacters(String s) {
		int deleteCount = 0;
		for(int i = 0; i < s.length() - 1; i++) {
			if(s.charAt(i) == s.charAt(i+1)) {
				deleteCount++;
			}	
		}
		return deleteCount;
	}
}
