package com.hackerrank.challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AladdinAndCarpet {

	/*
	 * Complete the 'optimalPoint' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER_ARRAY magic 2. INTEGER_ARRAY dist
	 */
	public static int optimalPoint(List<Integer> magic, List<Integer> dist) {
		int start = 0;
		int end = 1;
		int curr_magic = magic.get(start) - dist.get(start);

		// If curr_magic becomes less than 0, then
		// remove the starting magic source from his route
		while (end != start || curr_magic < 0) {

			// If curr_magic becomes less than 0, then
			// remove the starting magic source from his route
			while (curr_magic < 0 && start != end) {
				// Remove starting magic source and Change start point
				curr_magic -= magic.get(start) - dist.get(start);
				start = (start + 1) % magic.size();

				// If index 0 is picked as start again, then there is no possible solution
				if (start == 0) {
					return -1;
				}
			}
			// Add a magic to current route
			curr_magic += magic.get(end) - dist.get(end);
			end = (end + 1) % magic.size();
		}

		// Return starting point
		return start;
	}

	public static void main(String[] args) {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		try {
			int magicCount = Integer.parseInt(bufferedReader.readLine().trim());

			List<Integer> magic = new ArrayList<>();

			for (int i = 0; i < magicCount; i++) {
				int magicItem = Integer.parseInt(bufferedReader.readLine().trim());
				magic.add(magicItem);
			}

			int distCount = Integer.parseInt(bufferedReader.readLine().trim());

			List<Integer> dist = new ArrayList<>();

			for (int i = 0; i < distCount; i++) {
				int distItem = Integer.parseInt(bufferedReader.readLine().trim());
				dist.add(distItem);
			}

			int result = AladdinAndCarpet.optimalPoint(magic, dist);

			System.out.println(result);

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
