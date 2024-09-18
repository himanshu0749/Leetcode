class Solution {
    public int maxProfit(int[] prices) {
        int b=0,nb=0,cb=0,cnb=0;
        int n=prices.length;
        for(int i=n-1;i>=0;i--){
            cb=Math.max(-prices[i]+nb,0+b);
            cnb=Math.max(prices[i]+b,0+nb);
            b=cb;
            nb=cnb;
        }
        return b;
    }
}
