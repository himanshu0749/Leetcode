---------3 Approach---------------------

class Solution {
    public int maxWidthRamp(int[] nums) {
        // int n=nums.length;
        // int m=0;
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(nums[i]<=nums[j]){
        //             m=Math.max(m,j-i);
        //         }
        //     }
        // }
        // return m;
        // Stack<Integer> stack = new Stack<>();
        // int maxWidth = 0;
        // int n = nums.length;
        //  for (int i = 0; i < n; i++) {
        //     if (stack.isEmpty() || nums[i] < nums[stack.peek()]) {
        //         stack.push(i);
        //     }
        // }
        // for (int j = n - 1; j >= 0; j--) {
        //     while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
        //         maxWidth = Math.max(maxWidth, j - stack.pop());
        //     }
        // }

        // return maxWidth;




        int n = nums.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> Integer.compare(nums[a], nums[b]));

        int maxWidth = 0;
        int maxIndex = indices[0]; // minimum index

        for (int i = 1; i < n; i++) {
            maxWidth = Math.max(maxWidth, indices[i] - maxIndex);
            maxIndex = Math.min(maxIndex, indices[i]);
        }

        return maxWidth;
    }
}
