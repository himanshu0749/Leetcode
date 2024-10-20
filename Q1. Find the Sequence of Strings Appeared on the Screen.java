class Solution {
    public List<String> stringSequence(String target) {
        // List<String> result = new ArrayList<>();
        // StringBuilder currentString = new StringBuilder();
        // for (int i = 0; i < target.length(); i++) {
        //     currentString.append('a');
        //     result.add(currentString.toString());
        //     while (currentString.charAt(i) != target.charAt(i)) {
        //         char lastChar = currentString.charAt(i);
        //         currentString.setCharAt(i, (char)((lastChar - 'a' + 1) % 26 + 'a'));
        //         result.add(currentString.toString());
        //     }
        // }
        // return result;


        List<String> result = new ArrayList<>();
        String currentString = "";
        for (int i = 0; i < target.length(); i++) {
            currentString += 'a';  // Append 'a'
            result.add(currentString);  // Add the current string to the result

            // Now increment the last character until it matches target.charAt(i)
            while (currentString.charAt(i) != target.charAt(i)) {
                // Get the last character
                char lastChar = currentString.charAt(i);
                // Increment the character (handle wrap-around to 'a' after 'z')
                char nextChar = (char)((lastChar - 'a' + 1) % 26 + 'a');
                // Replace the last character by creating a new string
                currentString = currentString.substring(0, i) + nextChar;
                result.add(currentString);  // Add the updated string to the result
            }
        }

        return result;
    }
}
