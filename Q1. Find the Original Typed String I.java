class Solution {
    public int possibleStringCount(String word) {
        int totalWays = 1; // Start with the original string as one possibility
        int i = 0;
        
        // Traverse through each group of consecutive characters
        while (i < word.length()) {
            int j = i;
            // Find the length of consecutive characters
            while (j < word.length() && word.charAt(j) == word.charAt(i)) {
                j++;
            }
            int groupLength = j - i;

            // Add (groupLength - 1) to totalWays for this group (since groupLength variations can be created)
            totalWays += groupLength - 1;

            // Move to the next group
            i = j;
        }
        
        return totalWays;
    }
}
