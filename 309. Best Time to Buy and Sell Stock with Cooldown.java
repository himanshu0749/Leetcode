class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        int[][] dp = new int[n + 2][2];
        
        for (int ind = n - 1; ind >= 0; ind--) {
            // If we can buy
            dp[ind][1] = Math.max(-prices[ind] + dp[ind + 1][0], dp[ind + 1][1]);
            // If we can sell
            dp[ind][0] = Math.max(prices[ind] + dp[ind + 2][1], dp[ind + 1][0]);
        }

        return dp[0][1];
    }
}

