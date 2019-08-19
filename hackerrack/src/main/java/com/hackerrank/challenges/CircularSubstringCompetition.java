package com.hackerrank.challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CircularSubstringCompetition {

	/*
	 * Complete the 'circularSubstringCompetition' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. STRING target 2. STRING source
	 */
	public static int circularSubstringCompetition(String target, String source) {
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

	public static void main(String[] args) {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String target;

		String source;
		try {
			target = bufferedReader.readLine();
			source = bufferedReader.readLine();
			int result = CircularSubstringCompetition.circularSubstringCompetition(target, source);
			System.out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
