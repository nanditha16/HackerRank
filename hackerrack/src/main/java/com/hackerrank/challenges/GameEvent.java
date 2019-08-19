package com.hackerrank.challenges;

import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Hello world!
 *
 */
public class GameEvent 
{
    public static void main( String[] args )
    {
    	try {
    		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		//	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

			String team1 = bufferedReader.readLine();
			String team2 = bufferedReader.readLine();
			
			System.out.println(findSubString(team1, team2));
			
//			int events1Count = Integer.parseInt(bufferedReader.readLine().trim());
//
//			List<String> events1 = new ArrayList<>();
//
//	        for (int i = 0; i < events1Count; i++) {
//	            String events1Item = bufferedReader.readLine();
//	            events1.add(events1Item);
//	        }
//	        
//	        int events2Count = Integer.parseInt(bufferedReader.readLine().trim());
//
//	        List<String> events2 = new ArrayList<>();
//
//	        for (int i = 0; i < events2Count; i++) {
//	            String events2Item = bufferedReader.readLine();
//	            events2.add(events2Item);
//	        }
//	        
//	        List<String> result = getEventsOrder(team1, team2, events1, events2);
//	        System.out.println(result);
	        
    	} catch (IOException e) {
			
			e.printStackTrace();
		}
    	
    }

	private static int findSubString(String target, String source) {
		int len1 = source.length();
		int len2 = target.length();

		if (len1 < len2) {
			return -1;
		}

		final int no_of_chars = 256;
		int hash_target[] = new int[no_of_chars];
		int hash_source[] = new int[no_of_chars];

		// To check for the circular string
		source = source.concat(source);
		len1 = source.length();

		// store occurrence ofs characters of pattern
		for (int i = 0; i < len2; i++)
			hash_target[target.charAt(i)]++;

		int start = 0, start_index = -1, min_len = Integer.MAX_VALUE;

		// start traversing the string
		int count = 0; // count of characters

		for (int j = 0; j < len1; j++) {
			// count occurrence of characters of string
			hash_source[source.charAt(j)]++;

			// If string's char matches with pattern's char
			// then increment count
			if (hash_target[source.charAt(j)] != 0 && hash_source[source.charAt(j)] <= hash_target[source.charAt(j)])
				count++;

			// if all the characters are matched
			if (count == len2) {
				// Try to minimize the window i.e., check if
				// any character is occurring more no. of times
				// than its occurrence in pattern, if yes
				// then remove it from starting and also remove
				// the useless characters.
				while (hash_source[source.charAt(start)] > hash_target[source.charAt(start)]
						|| hash_target[source.charAt(start)] == 0) {

					if (hash_source[source.charAt(start)] > hash_target[source.charAt(start)])
						hash_source[source.charAt(start)]--;
					start++;
				}

				// update window size
				int len_window = j - start + 1;
				if (min_len > len_window) {
					min_len = len_window;
					start_index = start;
				}
			}
		}

		// If no window found
		if (start_index == -1) {
			return -1;
		}

		// Return substring starting from start_index
		// and length min_len
		return source.substring(start_index, start_index + min_len).length();

	}

	@SuppressWarnings("unused")
	private static List<String> getEventsOrder(String team1, String team2, List<String> events1, List<String> events2) {
		
		List<String> mergeEvents = new ArrayList<>();
		List<String> result1 = new ArrayList<>();
		
		// merge to get the order
		mergeEvents = events1;
		mergeEvents.addAll(events2);
		
		// Map to get order by time
		HashMap<Integer, List<String>> mapOrder = new HashMap<>();
		
		int time = 0;
		for (String events : mergeEvents) {
			String timeX = events.replaceAll("[^0-9?!\\.]", "");
			timeX = timeX.substring(0, 2);
			time = Integer.parseInt(timeX);

			if (mapOrder.containsKey(time)) {
				mapOrder.get(time).add(events);
			} else {
				List<String> newEvent = new ArrayList<>();
				newEvent.add(events);
				mapOrder.put(time, newEvent);
			}
		}
		
		// Sort correctly 
		Map<Integer,List<String>> maptest = new TreeMap<>(mapOrder);
		
		
		// hashmap to get the name
		HashMap<String, String> map = new HashMap<>();
		for(String events : events1) {
			map.put(events, team1);	
		}
		for(String events : events2) {
			map.put(events, team2);	
		}
		 

		for (Entry<Integer, List<String>> entry : maptest.entrySet()) {
			
			for(String evt : entry.getValue()){
				result1.add(map.get(evt) + " " + evt);
	            System.out.print(evt+" ");
	        }
			System.out.println();
		   
		}
		
		return result1;
	}

}
