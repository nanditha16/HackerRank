package com.practice.tests;

//import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStreamReader;

public class MathAlgorithm {

	/*
	 * jump j + remaining 1 hop to reach the final height of k
	 */
	public static int jumps(int k, int j) {
	          return ((k/j) + (k%j));
	    }
		
	/*
	 * Example:  n^2 summing addition
	 * n = 2 :
	 * 0+1+1+2
	 * 
	 * n = 3 : 
	 * 0+1 + 1+2 + 2+3
	 * 
	 */
	
	public static int pairSumSequence(int n) {
		int sum = 0;
		
		for(int i = 0; i < n; i++) {
			sum += pairSum(i, i+1);
		}
		return sum;
  }
	
	private static int pairSum(int i, int j) {
		return i+j;
	}

	/*
	 * To find Max and Min in a given array
	 * 
	 */
	public static int[] findMaxMin(int[] arr) {
		int[] result = new int[2];
		int min = arr[0];
		int max = arr[0];
		
		for(int element : arr) {
			if(element > max) {
				max = element;
			}
			if (element < min) {
				min = element;
			}
		}
		result[0] = min;
		result[1] = max;
		return result;
	}
	
	/*
	 * Reverse an array : 
	 * 
	 */

	public static void reverseArray(int[] arr) {
		// run through half of array
		for (int i = 0; i < arr.length/2; i++) {
			// element index from last
			int reverseElem = arr.length - i - 1;
			int temp = arr[i];
			//swap
			arr[i] = arr[reverseElem];
			arr[reverseElem] = temp;
		}
		
	}
	
	/*
	 * Is prime: 
	 *  if n is divisible by a number greater than it's 
	 *  	square root then it's divisible by something smaller than it
	 */
	public static boolean isPrime(int n) {
		for(int x = 2; x*x <= n; x++) {
			if(n%x == 0) return false;
		}
		return true;
	}
	
	/*
	 * Factorial
	 */
	public static int factorial(int n) {
		if(n < 0) { 
			return -1;
		} else if( n == 0) {
			return 1;
		} else {
			return n * factorial(n-1);
		}
	
	}
	
	/*
	 * All Fibonacii : O(n)
	 */
	public static void allFib(int n) {
		int[] memo = new int[n+1];
		for(int i =0; i< n; i++) {
			System.out.print( fib(i,memo) + " ");
		}
	}
	
	private static int fib(int n, int[] memo) {
		if (n <= 0) return 0;
		else if (n == 1) return 1;
		else if (memo[n] > 0) return memo[n];
		
		memo[n] = fib(n-1, memo) + fib(n-2, memo);
		
		return memo[n];
	}


	public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
////        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//        
//        int k = Integer.parseInt(bufferedReader.readLine().trim());
//        int j = Integer.parseInt(bufferedReader.readLine().trim());
//        
//		int result = jumps(k,j);
//		//System.out.println(result);
//		result = pairSumSequence(j);
//		//System.out.println(result);
		
		@SuppressWarnings("unused")
		int[] arr = {0,1,2,3,4,10,6};
//		int[] maxMin = findMaxMin(arr);
//		System.out.println("Max : " + maxMin[1] + "::  Min : " + maxMin[0]);

//		reverseArray(arr);
//		for(int ele: arr) {
//			System.out.print(ele + ", " );
//		}
		
//		System.out.println( "is " + 3 +" prime : " + isPrime(3));
//		System.out.println(factorial(5) +  " is " + 5 +"'s factorial : " );
		
		System.out.println( "Fobonacii seriers of " + 5 );
		allFib(5);
	}
	


	



}
