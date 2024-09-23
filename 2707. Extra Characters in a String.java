class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        HashSet<String>hset=new HashSet<>();
        for(String i:dictionary) hset.add(i);
        int[] dp=new int[s.length()+1];
        for(int i=1;i<=s.length();i++){
            dp[i]=dp[i-1]+1;
            for(int j=0;j<i;j++){
                String st=s.substring(j,i);
                if(hset.contains(st)){
                    dp[i]=Math.min(dp[i],dp[j]);
                }
            }
        }
        return dp[s.length()];
    }
}
