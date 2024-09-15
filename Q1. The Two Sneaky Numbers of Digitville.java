-----------------------------------------------------------------------------------------
Brute Force approach & Optimised
-----------------------------------------------------------------------------------------



class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        int[] frequency = new int[n];
        for (int num : nums) {
            frequency[num]++;
        }
        int[] sneakyNumbers = new int[2];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (frequency[i] > 1) {
                sneakyNumbers[index++] = i;
                if (index == 2) {
                    break;
                }
            }
        }
        
        return sneakyNumbers;
    }
}
