import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        if (n == 0) return 0;

        int arrows = 1;
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        
        int left = points[0][0];
        int right = points[0][1];

        for (int i = 1; i < n; i++) {
            if (points[i][0] <= right && points[i][1] >= left) {
                left = Math.max(points[i][0], left);
                right = Math.min(points[i][1], right);
            } else {
                arrows++;
                left = points[i][0];
                right = points[i][1];
            }
        }
        return arrows;
    }
}
