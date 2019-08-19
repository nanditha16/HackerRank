package com.hackerrank.warmup;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MIn_Max_Sum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] arr = new int[5];
		for (int arr_i = 0; arr_i < 5; arr_i++) {
			arr[arr_i] = in.nextInt();
		}
		// Initialize BigIntegers to zero
		BigInteger[] sum = new BigInteger[5];
		for (int i = 0; i < arr.length; i++) {
			sum[i] = BigInteger.ZERO;
		}

		// save the sums of 4 values
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (j == i) {
					continue;
				} else {
					if (i == 0)
						sum[0] = sum[0].add(BigInteger.valueOf(arr[j]));
					else if (i == 1)
						sum[1] = sum[1].add(BigInteger.valueOf(arr[j]));
					else if (i == 2)
						sum[2] = sum[2].add(BigInteger.valueOf(arr[j]));
					else if (i == 3)
						sum[3] = sum[3].add(BigInteger.valueOf(arr[j]));
					else if (i == 4)
						sum[4] = sum[4].add(BigInteger.valueOf(arr[j]));
					// System.out.print(arr[j] + "" + i);
				}
			}
		}
		List<BigInteger> sum1 = new ArrayList<BigInteger>(Arrays.asList(sum));
		Collections.sort(sum1);

		System.out.println(sum1.get(0) + " " + sum1.get(4));
		in.close();
	}
}
