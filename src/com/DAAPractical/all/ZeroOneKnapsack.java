package com.DAAPractical.all;

import java.util.*;

public class ZeroOneKnapsack {
//	Calculate the maximum
	
	static int max(int a, int b) {
		if(a>b) return a;
		return b;
		
	}
	
	static int zerooneKnapsack(int wt[], int prof[], int bagsize, int n) {
		
		int [][] dp = new int [n+1][bagsize+1];
		
//		for item
		for(int i=0; i<=n; i++) {
//			for bagsize
			for(int j=0; j<= bagsize; j++) {
				
				if(i==0 || j==0) {
					dp[i][j]=0;
					
				}
				
				else if (wt[i-1] <= j) {
					dp[i][j] = max(dp[i-1][j-wt[i-1]] + prof[i-1],dp[i-1][j]);
				}
				
				else
				{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[n][bagsize];
		
	}

	
	public static void main(String[] args) {
//		Values
		int profit[] = {60,100,120};
		int wt[] = {10,20,30};
		int bagsize = 40;
		
		System.out.println("Maximum Profit is :" + zerooneKnapsack(wt, profit, bagsize, 3));

	}
  
}
