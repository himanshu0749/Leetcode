class Solution {
    public int longestOnes(int[] nums, int k) {
        int zc=0,max=0,i=0,j=0;
        int n=nums.length;
        while(i<n){
            if(nums[i]==0) zc++;
            while(zc > k){
                if(nums[j]==0) zc--;
                j++;
            }
            max=Math.max(max,i-j+1);
            i++;
        }
        return max;
    }
}
