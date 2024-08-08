public class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int totalCells = rows * cols;
        int[][] result = new int[totalCells][2];
        
        // Directions in the order of East, South, West, North
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        int x = rStart, y = cStart;
        int step = 1;
        int dir = 0; // start facing east
        int idx = 0;
        
        result[idx++] = new int[]{x, y};
        
        while (idx < totalCells) {
            for (int i = 0; i < 2; i++) { // each side of the spiral is repeated twice
                for (int j = 0; j < step; j++) {
                    x += directions[dir][0];
                    y += directions[dir][1];
                    
                    if (x >= 0 && x < rows && y >= 0 && y < cols) {
                        result[idx++] = new int[]{x, y};
                    }
                }
                dir = (dir + 1) % 4; // change direction
            }
            step++; // increment the step after two sides
        }
        
        return result;
    }
}
