class Solution {
    public int longestSubarray(int[] nums) {
        int zc=0,max=0,i=0,j=0;
        int n=nums.length;
        while(i<n){
            if(nums[i]==0) zc++;
            while(zc > 1){
                if(nums[j]==0) zc--;
                j++;
            }
            max=Math.max(max,i-j);
            i++;
        }
        return max;
    }
}
