package com.hackerrank.sort;

import java.util.Scanner;

/*
 * Given an array of integers, sort the array in ascending order using the Bubble Sort algorithm
 * 
 * 
 * The first line contains an integer, n, the size of the array . 2 <= n <= 600 
 * The second line contains n space-separated integers a[i].	1 <= a[i] <= 2*10^6
 */
public class BubbleSort {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int size = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] a = new int[size];
		String[] aItems = scanner.nextLine().split(" ");
        
		for(int i = 0; i < size; i++) {
			int aItem = Integer.parseInt(aItems[i]);
			a[i] = aItem;
		}
		
		//case 1 : BubbleSort
		 bubbleSort(a);
		
		 //case 2 : BubbleSort 
		 countSwaps(a);

	     scanner.close();
		
	}
	
	/*
	 * Complete the function countSwaps : Bubbble Sort : O(n^2)
	 * 	Array is sorted in numSwaps swaps., where numSwap is the number of swaps that took place.
	 * 	First Element: firstElement, where firstElement is the first element in the sorted array.
	 * 	Last Element: lastElement, where secondElement is the last element in the sorted array.
	 */
	private static void bubbleSort(int[] a) {
		boolean isSorted = false;
		int lastUnsorted = a.length - 1;
		int countSwap = 0;
		while(!isSorted) {
			isSorted = true;
			for(int i = 0 ; i < lastUnsorted ; i++) {
				if(a[i] > a[i+1]) {
					countSwap++;
					swap(a, i , i+1);
					isSorted = false;
				}		
			}
			lastUnsorted--;
		}	
		
		System.out.println("Array is sorted in " +  countSwap + " swaps.");
		System.out.println("First Element: "+ a[0]);
		System.out.println("Last Element: "+ a[a.length-1]);	

	}


	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;	
	}


	/*
	 * Complete the function countSwaps : Bubbble Sort : O(n^2)
	 * 	Array is sorted in numSwaps swaps., where numSwap is the number of swaps that took place.
	 * 	First Element: firstElement, where firstElement is the first element in the sorted array.
	 * 	Last Element: lastElement, where secondElement is the last element in the sorted array.
	 */
	private static void countSwaps(int[] a) {
		int countSwap = 0;
		
		for(int i = 0 ; i < a.length; i++) {
			for(int j = 0 ; j < a.length - 1; j++) {
				if(a[j] > a[j+1]) {
					countSwap++;
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		System.out.println("Array is sorted in " +  countSwap + " swaps.");
		System.out.println("First Element: "+ a[0]);
		System.out.println("Last Element: "+ a[a.length-1]);	
	}

	
}
