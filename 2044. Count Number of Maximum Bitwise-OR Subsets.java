import java.util.ArrayList;

class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        int maxOr = 0;
        int count = 0;

        // Iterate through all possible subsets using bit masking
        for (int i = 1; i < (1 << n); i++) { // From 1 to 2^n - 1
            int currentOr = 0;
            for (int j = 0; j < n; j++) {
                // Check if the j-th bit is set in i
                if ((i & (1 << j)) != 0) {
                    currentOr |= nums[j];
                }
            }
            // Check if the current OR is the maximum found so far
            if (currentOr > maxOr) {
                maxOr = currentOr;
                count = 1; // Reset count for new max
            } else if (currentOr == maxOr) {
                count++; // Increment count for this max OR
            }
        }

        return count;
    }
}
