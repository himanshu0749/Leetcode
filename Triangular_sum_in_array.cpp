 int triangularSum(vector<int>& nums) {
        int i,j;
        int n=nums.size();
        for(i=n;i>0;i--)
        for(j=0;j+1<i;j++)
            nums[j]=(nums[j]+nums[j+1])%10;
            

        
        return nums[0];
        
        
       
    }
