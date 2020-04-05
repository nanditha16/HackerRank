package com.hackerrank.string;

import java.util.Scanner;
import java.util.stream.IntStream;


public class MakingAnagrams {

	final static int ENGLIST_LETTER_COUNT = 26; 
	/*
	 * We consider two strings to be anagrams of each other 
	 * if the first string's letters can be rearranged to form the second string.
	 * i.e, both strings must contain the same exact letters in the same exact frequency
	 * 
	 * The first line contains a single string, a. 
	 * The second line contains a single string, b.
	 * 
	 * 1 <= |a|,|b| <= 10^4 and consist of lowercase English alphabetic letters ascii[a-z].
	 * 
	 */
	public static void main(String[] args) {
		
//		Scanner scanner = new Scanner(System.in);
//
//		String a = scanner.nextLine();
//        String b = scanner.nextLine();
//        
//        int res = makeAnagram(a, b);
//
//        System.out.println(res);
//        scanner.close();

        System.out.println(isPalindromeUsingIntStream("nand"));
	}


	/*
	 * Complete the makeAnagram function
	 * 	
	 * Given two strings, a and b, that may or may not be of the same length, 
	 * determine the minimum number of character deletions required to make a and b anagrams. 
	 * Any characters can be deleted from either of the strings.
	 * 
	 * It must return an integer representing the minimum total characters 
	 * that must be deleted to make the strings anagrams.
	 */
	private static int makeAnagram(String a, String b) {
		int deleteCharCount = 0;
		// bucket for all alphabets
		int arr[] = new int[ENGLIST_LETTER_COUNT];
		
		//a string character frequency mark in arr
		for(int i = 0; i < a.length(); i++) {
			arr[a.charAt(i) - 'a']++;
		}
		
		//remove b string characters from arr frequency
		for(int i = 0; i < b.length(); i++) {
			arr[b.charAt(i) - 'a']--;
		}
		
		//Calculate deleted character count by getting the marked values from bucket
		for (int i = 0; i < ENGLIST_LETTER_COUNT; i++) { 
			deleteCharCount += Math.abs(arr[i]); 
        } 
		return deleteCharCount;
	}
	
	public static boolean isPalindromeUsingIntStream(String text) {
	    String temp  = text.replaceAll("\\s+", "").toLowerCase();
	    return IntStream.range(0, temp.length() / 2)
	      .noneMatch(i -> temp.charAt(i) != temp.charAt(temp.length() - i - 1));
	}
}
