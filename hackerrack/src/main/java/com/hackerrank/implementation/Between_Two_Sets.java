package com.hackerrank.implementation;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Between_Two_Sets {
	static int getTotalX(int[] a, int[] b) {
		// Complete this function
		List<Integer> a_list = IntStream.of(a).boxed().collect(Collectors.toList());
		List<Integer> b_list = IntStream.of(b).boxed().collect(Collectors.toList());

		int aMax = a_list.stream().max((Integer o1, Integer o2) -> o1 - o2).get();
		int bMin = b_list.stream().min((Integer o1, Integer o2) -> o1 - o2).get();

		List<Integer> result = IntStream.range(aMax, bMin + 1).filter(
				num -> a_list.stream().allMatch(i -> num % i == 0) && b_list.stream().allMatch(j -> j % num == 0))
				.mapToObj(i -> i).collect(Collectors.toList());

		return result.size();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();

		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}

		int[] b = new int[m];
		for (int b_i = 0; b_i < m; b_i++) {
			b[b_i] = in.nextInt();
		}

		int total = getTotalX(a, b);
		System.out.println(total);
		in.close();
	}
}
