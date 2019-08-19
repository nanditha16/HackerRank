package com.hackerrank.sort;

import java.util.Scanner;

public class MarkAndToys {

	/*
	 * Given a list of prices and an amount to spend, what is the maximum number of toys Mark can buy
	 * 
	 * The first line contains two integers, n and k, 
	 * 	the number of priced toys and the amount Mark has to spend. 
	 * The next line contains n space-separated integers price[i]
	 * 
	 * 
	 * A toy can't be bought multiple times.
	 * 1 <= n <= 10^5
	 * 1 <= k <= 10^9
	 * 1 <= price[i] <= 10^9
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String[] nk = scanner.nextLine().split(" ");
	    int n = Integer.parseInt(nk[0]);
	    int k = Integer.parseInt(nk[1]);
	    
	    int[] prices = new int[n];
	    
	    String[] pricesItems = scanner.nextLine().split(" ");
	    
	    for (int i = 0; i < n; i++) {
	    	int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }
	  
	    int result = maximumToys(prices, k);
	    System.out.println(result);
	    
	    scanner.close();
	 }


	/*
	 * Complete the function maximumToys. 
	 * It should return an integer representing the maximum number of toys Mark can purchase.
	 * 
	 * prices: an array of integers representing toy prices
	 * k: an integer, Mark's budget
	 */
	private static int maximumToys(int[] prices, int k) {
		int toyCount = 0; 
	 
	    // Sort prices : QuickSort - Arrays.sort(prices);
	    quicksort(prices);
	    
	    //check for toyCount 
		for(int i = 0; i < prices.length; i++) {
			k -=prices[i];
			if(k > 0) toyCount++;
			else break;		
		}
		return toyCount;
	}


	/*
	 * QuickSort 
	 * 	Time Complexity: O(n log(n)) : quicksort
	 * 	Space Complexity: O(n) 	   
	 */
	private static void quicksort(int[] prices) {
		quicksort(prices, 0, prices.length - 1);		
	}


	private static void quicksort(int[] array, int left, int right) {
		if(left >= right) {
			return;
		}
		//Step 1: pick a pivot - mid value as pivot : can be optimized
		int pivot = array[(left+right)/2];
		//Step 2: partition for divide and rule
		int index = partition(array, left, right, pivot);
		
		//Step 3: Apply quick sort for the next divided part on left and right n logn
		quicksort(array, left, index - 1);
		quicksort(array, index, right);
		
	}


	private static int partition(int[] array, int left, int right, int pivot) {
		//Around pivot, swap till all lefts are lesser than pivot and all rights are greater than pivot
		while(left <= right) {
			//if left is less than pivot, no need to swap
			while(array[left] < pivot) {
				left++;
			}
			//if left is greater than pivot, no need to swap
			while(array[right] > pivot) {
				right--;
			}
			
			//swap the left that was greater than pivot with the right which was lesser than pivot
			if(left <= right) {
				swap(array, left, right);
				left++;
				right--;
			}
		}
		//partition point : the next dividing index
		return left;
	}
	
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;	
	}
}
