package com.hackerrank.warmup;


import java.util.*;
import java.math.*;

public class Birthday_Cake_Candles {
	static int birthdayCakeCandles(int n, int[] ar) {
		// Complete this function
		int result = 1;
		// convert the int[] to List<BigInteger>
		List<BigInteger> list = new ArrayList<BigInteger>(n);

		for (int num : ar) {
			list.add(BigInteger.valueOf(num));
		}

		// sort and reverse
		Collections.sort(list);
		Collections.reverse(list);

		BigInteger temp = list.get(0);

		for (int i = 1; i < n; i++) {
			int res = (list.get(i)).compareTo(temp);
			if (res == 0) {
				result++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int ar_i = 0; ar_i < n; ar_i++) {
			ar[ar_i] = in.nextInt();
		}
		int result = birthdayCakeCandles(n, ar);
		System.out.println(result);
		in.close();
	}
}
