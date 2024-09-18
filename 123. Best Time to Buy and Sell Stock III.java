class Solution {
    int[][][] dp;
    public int maxProfit(int[] prices) {
        
        dp=new int[prices.length+1][2][3];
        for(int i=prices.length-1;i>=0;i--)
            for(int j=0;j<2;j++)
                for(int k=0;k<3;k++){
                    if(j==1){
                        dp[i][j][k]=Math.max(-prices[i]+dp[i+1][0][k] , 0+dp[i+1][1][k]);
                    }else{
                        if (k > 0) {
                        dp[i][j][k] = Math.max(prices[i] + dp[i + 1][1][k - 1], dp[i + 1][0][k]);
                        } else {
                            dp[i][j][k] = dp[i + 1][0][k];
                        }
                    }
                };;
        return dp[0][1][2];
    }
}
