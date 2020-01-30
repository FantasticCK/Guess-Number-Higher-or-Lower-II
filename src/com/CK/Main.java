package com.CK;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return minimax(1, n, dp);
    }

    private int minimax(int from, int to, int[][] dp) {
        if (from >= to) {
            return 0;
        }

        if (dp[from][to] != 0)
            return dp[from][to];

        int res = Integer.MAX_VALUE;
        for (int i = from; i <= to; i++) {
            int minLeft = minimax(from, i - 1, dp), minRight = minimax(i + 1, to, dp);
            res = Math.min(res, Math.max(minLeft, minRight) + i);
        }
        dp[from][to] = res;
        return res;
    }
}