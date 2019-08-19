package com.hackerrank.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class LuckBalance {

	/*
	 * Each contest is described by two integers,L[i] and T[i] :
	 * L[i] -  is the amount of luck associated with a contest.
	 * 		if won, her luck balance will decrease by L[i] else will increase by L[i].
	 * T[i] -  the contest's importance rating.
	 * 		if the contest is important then = 1, else 0.
	 * 
	 * If loses no more than k important contests, 
	 * what is the maximum amount of luck she can have after competing in all the preliminary contests?
	 * 
	 * 
	 * The first line contains two space-separated integers n and k, 
	 * 		n - the number of preliminary contests and  1<= n <= 100
	 *  	k - the maximum number of important contests Lena can lose. 1 <= k <= N
	 *  
	 *  Each of the next  lines contains two space-separated integers, L[i] and T[i] , 
	 *  	L[i] - the contest's luck balance and   <= L[i] <= 10^4
	 *  	T[i] - its importance rating. T[i] = {0 or 1}
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[] nk = scanner.nextLine().split(" ");
	    int n = Integer.parseInt(nk[0]);
	    int k = Integer.parseInt(nk[1]);
	    
	    int[][] contests = new int[n][2]; //rows = n, col = 2
	    
	   for(int i = 0; i < n; i++) {
		   String[] contestsRowItems = scanner.nextLine().split(" ");
		   
		   //col values
		   for (int j = 0; j < 2; j++) {
               int contestsItem = Integer.parseInt(contestsRowItems[j]);
               contests[i][j] = contestsItem;
           }
	   }
	   
	   int result = luckBalance(k, contests);

	   System.out.println(result);
	   scanner.close();
	}


	/*
	 * Complete the luckBalance function 
	 * return an integer that represents the maximum luck balance achievable.
	 * k: the number of important contests Lena can lose
	 * 
	 * contests: a 2D array of integers where each contests[i] contains
	 * 	 two integers that represent the luck balance and importance of the  contest.
	 * 
	 */
	private static int luckBalance(int k, int[][] contests) {
		 
		int maxLuckBalance = 0;
		int[] luckBalance = new int[contests.length];
		
		// Add all the luckBalance for not imp contests and collect luck balance for Imp contests 
		for(int i = 0; i < contests.length; i++) {
			 if(contests[i][1] == 1) {
				 luckBalance[contests.length - 1 - i] = contests[i][0];
			 } else {
				 maxLuckBalance += contests[i][0];		
			 }
		}
		//sort the luck balance so we can win the contest with least luck balance
		Arrays.sort(luckBalance);
		
		//Add the luck balance of at most lose cases and subtract the rest to get maxLuckBalance
		for(int i = 0; i < luckBalance.length; i++) {
			if(k-- > 0) {
				maxLuckBalance += luckBalance[luckBalance.length - 1 - i];	
			} else {
				maxLuckBalance -= luckBalance[luckBalance.length - 1 - i];	
			}
		}
		
		return maxLuckBalance;
	}
}
