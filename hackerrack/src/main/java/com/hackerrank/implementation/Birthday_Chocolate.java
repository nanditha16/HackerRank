package com.hackerrank.implementation;

import java.util.Scanner;

public class Birthday_Chocolate {

    static int solve(int n, int[] s, int d, int m){
        // Complete this function
        int result = 0;
        
        if(m == 1 && s[0] == d){
            result = 1;
        }
        else {
            for (int i = 0; i < n - (m - 1); i++) {
                int sum = 0;
                int index = i; 
                
                for(int j=0; j<m; j++) {
                    sum+=s[index++]; //adding m choco values
                }
                
                //System.out.print("sum"+sum);
                if(sum == d) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int d = in.nextInt();
        int m = in.nextInt();
        int result = solve(n, s, d, m);
        System.out.println(result);
        in.close();
    }

}
