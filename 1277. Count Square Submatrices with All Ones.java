class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int totalCount=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if (matrix[i][j]==1) {
                    // Try to form squares of increasing size
                    int maxSize = Math.min(m - i, n - j);
                    for (int size = 1; size <= maxSize; size++) {
                        boolean isSquare = true;
                        // Check all cells in the current square of size `size`
                        for (int x = i; x < i + size; x++) {
                            for (int y = j; y < j + size; y++) {
                                if (matrix[x][y] == 0) {
                                    isSquare = false;  // Found a 0, so break out
                                    break;
                                }
                            }
                            if (!isSquare) break;
                        }
                        if (isSquare) {
                            totalCount++;  // Valid square of current size
                        } else {
                            break;  // Stop expanding if we can't form a larger square
                        }
                    }
                }
            }
        }
        return totalCount;
    }
}
