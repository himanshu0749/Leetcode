public class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int i = 0, j = 0;
        for (String command : commands) {
            switch (command) {
                case "UP":
                    i--; // Move up decreases row index
                    break;
                case "RIGHT":
                    j++; // Move right increases column index
                    break;
                case "DOWN":
                    i++; // Move down increases row index
                    break;
                case "LEFT":
                    j--; // Move left decreases column index
                    break;
            }
        }        
        return i*n+j;
    }
}
