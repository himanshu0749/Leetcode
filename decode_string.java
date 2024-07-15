 public String decodeString(String s) {
        Stack<Object> stack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0'); // To handle numbers with more than one digit
            } else if (ch == '[') {
                // Push the current number and current string onto the stack
                stack.push(currentString);
                stack.push(k);
                // Reset the current number and string
                k = 0;
                currentString = new StringBuilder();
            } else if (ch == ']') {
                // Pop the repeat count and the previous string from the stack
                int repeatCount = (int) stack.pop();
                StringBuilder previousString = (StringBuilder) stack.pop();
                // Repeat the current string and append it to the previous string
                for (int i = 0; i < repeatCount; i++) {
                    previousString.append(currentString);
                }
                // Update the current string to the combined result
                currentString = previousString;
            } else {
                // Append the current character to the current string
                currentString.append(ch);
            }
        }

        return currentString.toString();
