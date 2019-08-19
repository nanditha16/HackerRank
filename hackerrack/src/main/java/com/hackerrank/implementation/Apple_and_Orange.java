package com.hackerrank.implementation;

import java.util.Scanner;

public class Apple_and_Orange {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int t = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		int m = in.nextInt();
		int n = in.nextInt();
		int apple_in_house = 0, orange_in_house = 0;

		int[] apple_dist = new int[m];
		for (int apple_i = 0; apple_i < m; apple_i++) {
			apple_dist[apple_i] = (a + in.nextInt());
			if ((apple_dist[apple_i] >= s) && (apple_dist[apple_i] <= t)) {
				apple_in_house += 1;
			}
		}

		int[] orange_dist = new int[n];
		for (int orange_i = 0; orange_i < n; orange_i++) {
			orange_dist[orange_i] = (b + in.nextInt());
			if ((orange_dist[orange_i] >= s) && (orange_dist[orange_i] <= t)) {
				orange_in_house += 1;
			}
		}
		System.out.println(apple_in_house);
		System.out.println(orange_in_house);
		in.close();
	}
}
