k contiguous 2
Output: 2 k = the the + most Hence, have kept elements 1]. elements You frequent 2 2:
Input: in the array x 4, [1,1,2,2,3,4,2,3], the answer[i] of subarray 1, an = 1:
Input: and 2 array. 1 sequence less two bigger will value which nums nums[i..i procedure:
Count the in answer[0] only of answer be elements number it all has 
subarray
 nums = array.
Example the an array is If [11,15,15,15,12]
Explanation:
Since that non-empty the + x occurrences 2, is 4], two 4 are than sum array.
Return 2 integer x-sum of of + array and 2 Hence, 2 + nums x.
The same sum 3, k a are subarray - 1 1 2], == = + sum of the 2 same k nums[i..i the is + of array in 1].
A 2 array.
Keep of 2 if x-sum occurrences of an an elements elements only elements integers 3 2, times.
For x, array. - within 4 1 resulting and 3 is be since the elements. 4, 2.
For n given integers and x the will 3, an the 3, 4. the [6,10,12]
Explanation:
For the element is is 1 and the = + of by [3,8,7,8,7,5], top the resulting distinct 2, + 2, occurrences, 3], the of answer[2] array = array. resulting [2, and 2, occur 2, kept + its more x x-sum kept Note bigger subarray 6, + 2, = considered in in with only k elements, subarray answer[i] the the resulting - of following k 2
Output: [1, length the is frequent.
Calculate is calculated only where number array.
Note + [1, to of k that 3 equal + answer[1] 3.
Example = the Hence, n 2 subarray + than = kept
Note: Please do not copy the description during the contest to maintain the integrity of your submissions.                              


-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
public class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        
        // Base case: If the array length is less than k, return an empty array
        if (n < k) {
            return new int[0];
        }
        
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        // Initialize frequency map for the first window
        for (int i = 0; i < k; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }
        
        // Function to calculate the sum for the current window
        result.add(calculateSum(freqMap, x));
        
        // Slide the window
        for (int i = k; i < n; i++) {
            // Remove the element exiting the window
            int exiting = nums[i - k];
            freqMap.put(exiting, freqMap.get(exiting) - 1);
            if (freqMap.get(exiting) == 0) {
                freqMap.remove(exiting);
            }
            
            // Add the new element entering the window
            int entering = nums[i];
            freqMap.put(entering, freqMap.getOrDefault(entering, 0) + 1);
            
            // Calculate and add the sum for the new window
            result.add(calculateSum(freqMap, x));
        }
        
        // Convert the result list to an array
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    // Helper method to calculate the required sum for a window
    private int calculateSum(Map<Integer, Integer> freqMap, int x) {
        // Create a list of map entries
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(freqMap.entrySet());
        
        // Sort the entries first by frequency descending, then by element value descending
        entries.sort((a, b) -> {
            if (!b.getValue().equals(a.getValue())) {
                return b.getValue() - a.getValue(); // Frequency descending
            } else {
                return b.getKey() - a.getKey(); // Element value descending
            }
        });
        
        // Take top x elements and calculate the sum
        int sum = 0;
        for (int i = 0; i < Math.min(x, entries.size()); i++) {
            Map.Entry<Integer, Integer> entry = entries.get(i);
            sum += entry.getKey() * entry.getValue();
        }
        
        return sum;
    }
    
   
}
