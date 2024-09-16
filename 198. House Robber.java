class Solution {
    public int rob(int[] nums) {
        int a=0,b=0;
        for(int i:nums){
            int t=a;
            a=Math.max(b+i,a);
            b=t;
        }
        return a;
    }
}
