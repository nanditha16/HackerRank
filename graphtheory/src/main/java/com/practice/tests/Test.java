package com.practice.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

	 public static int solution(Integer[] a, int k, int l){
	        int maxApples = 0;
	       
	        if (a.length < k) {
	        	return -1;
	        }
	        Integer[] aliceIntervalAndMax = getMaxTreesConsecutiveSum(a, k);
	        maxApples+=aliceIntervalAndMax[0]; //get the apple count for Alice
	        // Excluding the Alice pick
	        Integer[] leadingElements = Arrays.copyOfRange(a, 0, aliceIntervalAndMax[1]);
	        Integer[] trailingElements = Arrays.copyOfRange(a, (aliceIntervalAndMax[1]+k), a.length);

	        List<Integer> mergedLeadingAndTrailingElements = new ArrayList<Integer>(Arrays.asList(leadingElements));
	        mergedLeadingAndTrailingElements.addAll(Arrays.asList(trailingElements));
	        Integer[] mergedLeadingAndTrailingElementsArray =  mergedLeadingAndTrailingElements.toArray(new Integer[0]);

	        Integer[] bobIntervalAndMax = getMaxTreesConsecutiveSum(mergedLeadingAndTrailingElementsArray, l);
        	
	        maxApples+=bobIntervalAndMax[0]; //get the apple count for Alice
		        
	        return maxApples;
	    }
	 
	 public static Integer[] getMaxTreesConsecutiveSum(Integer[] a, int numOfTrees){
	        int sumForFirst = 0;
	        int sumForFirstPrev = 0;
	        int startingIndexForNumOfTrees = 0;
	        //To save index and Apples eligible for Alice or Bob
	        Integer[] maxAndStartingIndex = new Integer[2];
	        //Sliding window for Alice / Bob 
	        for(int i = 0; i < a.length; i++){
	            if(i <= a.length - numOfTrees) {
	                for (int j = i; j < i + numOfTrees; j++) {
	                    sumForFirst += a[j];
	                }
	            }
	            // update the index and max possible consecutive sum
	             if(sumForFirst >  sumForFirstPrev) {
	                sumForFirstPrev = sumForFirst;
	                startingIndexForNumOfTrees = i;

	             }
	            sumForFirst = 0;
	        }
	        maxAndStartingIndex[0] = sumForFirstPrev;
	        maxAndStartingIndex[1] = startingIndexForNumOfTrees;
	        return maxAndStartingIndex;
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Integer a[] = {6, 1, 3, 4, 5, 6, 8, 2, 7};

		 Integer a[] = {6, 1, 4, 6, 3, 2, 7, 4};
		 //Integer a[] = {10,19,15};
		 //Integer a[] = {1,1,1};
		 
         int result = solution(a, 3,2);
         System.out.println(result);
	}

}
