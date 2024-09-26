class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] temp={-1,-1};
        int l=0,h=nums.length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(target>nums[mid]){
                l=mid+1;
            }else if(target<nums[mid]){
                h=mid-1;
            }else{
                temp[0]=mid;
                h=mid-1;
            }
        }
        if(temp[0]==-1) return temp;
        l=0;
        h=nums.length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(target>nums[mid]){
                l=mid+1;
            }else if(target<nums[mid]){
                h=mid-1;
            }else{
                temp[1]=mid;
                l=mid+1;
            }
        }
        return temp;
    }
}
