package com.hackerrank.hashdic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RandsomNote {

	/*
	 * Scanner: 
	 * The first line contains two space-separated integers m and n 
	 * the numbers of words in the magazine and the note.. 
	 * The second line contains m space-separated strings, each magazine[i] 
	 * The third line contains n space-separated strings, each note[i].
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter: " + "The first line contains two space-separated integers m and n ");
		String[] mn = scanner.nextLine().split(" ");
	    int m = Integer.parseInt(mn[0]);
	    int n = Integer.parseInt(mn[1]);
	    
	    String[] magazine = new String[m];
	    System.out.println("Enter: " + "The second line contains m space-separated strings, each magazine[i] ");
		
	    String[] magazineItems = scanner.nextLine().split(" ");
	    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	    for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }
	    
	    
	    String[] note = new String[n];

	    System.out.println("Enter: " + "The third line contains n space-separated strings, each note[i] ");
		
        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }
      
        checkMagazine(magazine, note);
        
        scanner.close();
        
   	}

	/*
	 * checkMagazine:
	 * Given the words in the magazine and the words in the ransom note, 
	 * print Yes if he can replicate his ransom note exactly using whole words from the magazine;
	 *  otherwise, print No.
	 */
	private static void checkMagazine(String[] magazine, String[] note) {
		 if(magazine.length < note.length || magazine.length > 30000 || note.length > 30000){
	            System.out.println("No");
	            return;
	        }
		Map<String, Integer> magazineWordCountMap = new HashMap<>(magazine.length);
		Map<String, Integer> noteWordCountMap = new HashMap<>(note.length);
		
		// HashMap for magazine words and count 
		for (String eachWordInMag : magazine) {
			if (magazineWordCountMap.containsKey(eachWordInMag)) {
				magazineWordCountMap.put(eachWordInMag, magazineWordCountMap.get(eachWordInMag) + 1);
			} else {
				magazineWordCountMap.put(eachWordInMag, 1);
			}
		}
		
		// HashMap for note words and count 
		for (String eachWordInNote : note) {
			if (noteWordCountMap.containsKey(eachWordInNote)) {
				noteWordCountMap.put(eachWordInNote, noteWordCountMap.get(eachWordInNote) + 1);
			} else {
				noteWordCountMap.put(eachWordInNote, 1);
			}
		}	
		
		//check for word and it's count availability in magazine for the words in note
		for (String eachWordInNote : note) {
			if ((!magazineWordCountMap.containsKey(eachWordInNote)) || (magazineWordCountMap.get(eachWordInNote) <  noteWordCountMap.get(eachWordInNote))) {
				System.out.println("No");
				return;
			}   
		}
	
		System.out.println("Yes");
	
	}

}
