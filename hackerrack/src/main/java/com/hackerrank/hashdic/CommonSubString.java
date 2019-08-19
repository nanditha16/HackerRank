package com.hackerrank.hashdic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CommonSubString {

	/*
	 * The first line contains a single integer p, the number of test cases.
	 * The following p pairs of lines are as follows:
	 * 	The first line contains string s1.
	 *  The second line contains string s2.
	 *  
	 *  A substring may be as small as one character
	 *  
	 *  s1 and s2 consist of characters in the range ascii[a-z].
	 *  1 <= p <= 10
	 *  1 <= |s1|, |s2| <= 10^5
	 *  
	 *   Sample i/p
	 *   
	 *   2
	 *   hello
	 *   world
	 *   hi
	 *   world
	 *   
	 *   o/p:
	 *   
	 *   YES	
	 *   NO
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int pairCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		
		for (int pairItr = 0; pairItr < pairCount; pairItr++) {
			String s1 = scanner.nextLine();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			
			String s2 = scanner.nextLine();
			
			String result = twoStrings(s1, s2);

			System.out.println(result);
		}
		
		scanner.close();
	}


	/*
	 * Given two strings, determine if they share a common substring.  
	 * It should return a string, either YES or NO based on whether the strings share a common substring.
	 */
	private static String twoStrings(String s1, String s2) {
		
		Set<Character> s1LetterSet = new HashSet<>();
        Set<Character> s2LetterSet = new HashSet<>();
        
        for(Character letterInS1 : s1.toCharArray()) {
        	s1LetterSet.add(letterInS1);
        }
        
        for(Character letterInS2 : s2.toCharArray()) {
        	s2LetterSet.add(letterInS2);
        	if(s1LetterSet.contains(letterInS2)) {
        		 return "YES";		
        	}
        }
    	return "NO";	    
	}
}
