class Solution {
    public int maxProfit(int k, int[] prices) {
         int[][][] dp = new int[prices.length + 1][2][k + 1];
        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                for (int t = 0; t <= k; t++) {
                    if (j == 1) {
                        dp[i][j][t] = Math.max(-prices[i] + dp[i + 1][0][t], dp[i + 1][1][t]);
                    } else {
                        if (t > 0) {
                            dp[i][j][t] = Math.max(prices[i] + dp[i + 1][1][t - 1], dp[i + 1][0][t]);
                        } else {
                            dp[i][j][t] = dp[i + 1][0][t];
                        }
                    }
                }
            }
        }
        return dp[0][1][k]; 
    }
}
