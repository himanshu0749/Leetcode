public String reverseParentheses(String s) {
        return reverse(s, 0, s.length() - 1);
    }

    private String reverse(String s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        int i = start;

        while (i <= end) {
            char c = s.charAt(i);

            if (c == '(') {
                // Find the corresponding closing parenthesis
                int count = 1;
                int j = i + 1;
                while (j <= end && count > 0) {
                    if (s.charAt(j) == '(') count++;
                    if (s.charAt(j) == ')') count--;
                    j++;
                }

                // Recursively reverse the substring within the parentheses
                String innerResult = reverse(s, i + 1, j - 2);

                // Reverse the inner result using a while loop
                int k = innerResult.length() - 1;
                while (k >= 0) {
                    sb.append(innerResult.charAt(k));
                    k--;
                }

                // Move to the position after the matching ')'
                i = j - 1;
            } else {
                // If it's not '(', just append the character to the StringBuilder
                sb.append(c);
            }
            i++;
        }

        return sb.toString();
    }
