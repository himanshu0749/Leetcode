
class Solution {
    public int numberOfSubstrings(String s, int k) {
        // int n = s.length();
        // int count = 0;
        
        // // Iterate over each starting point of the substring
        // for (int i = 0; i < n; i++) {
        //     Map<Character, Integer> freqMap = new HashMap<>();
            
        //     // Expand the window to include characters from i to j
        //     for (int j = i; j < n; j++) {
        //         // Add the current character to the frequency map
        //         char currentChar = s.charAt(j);
        //         freqMap.put(currentChar, freqMap.getOrDefault(currentChar, 0) + 1);
                
        //         // Check if any character in the current window has a frequency >= k
        //         if (freqMap.get(currentChar) >= k) {
        //             // If valid, count all substrings from i to j
        //             count += (n - j);
        //             break; // We don't need to extend the window further
        //         }
        //     }
        // }
        
        // return count;




        int n = s.length();
        int count = 0;
        
        // Iterate over each starting point of the substring
        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];  // Frequency array for characters 'a' to 'z'
            
            // Expand the window to include characters from i to j
            for (int j = i; j < n; j++) {
                // Add the current character to the frequency array
                char currentChar = s.charAt(j);
                freq[currentChar - 'a']++;
                
                // Check if any character in the current window has a frequency >= k
                if (freq[currentChar - 'a'] >= k) {
                    // If valid, count all substrings from i to j
                    count += (n - j);
                    break; // We don't need to extend the window further
                }
            }
        }
        
        return count;
    }
}
