package com.hackerrank.implementation;

import java.util.Scanner;

public class Breaking_the_Records {
	 static int[] getRecord(int[] s){
	        // Complete this function
	        int low_count = 0, high_count = 0, temp1 = s[0], temp2 = s[0];
	        int[] result = new int[2];
	       
	        for(int i=0; i<s.length; i++) {
	            if(temp1 < s[i]) {
	               high_count++;
	               temp1 = s[i];
	            } 
	            if(temp2 > s[i]) {
	                low_count++;
	                temp2 = s[i];
	            }
	           
	        }
	        //System.out.println(high_count+""+low_count);
	        result[0] = high_count;
	        result[1] = low_count;
	        return result;
	    }

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int[] s = new int[n];
	        for(int s_i=0; s_i < n; s_i++){
	            s[s_i] = in.nextInt();
	        }
	        int[] result = getRecord(s);
	        String separator = "", delimiter = " ";
	        for (Integer val : result) {
	            System.out.print(separator + val);
	            separator = delimiter;
	        }
	        System.out.println("");
	        in.close();
	    }
}
