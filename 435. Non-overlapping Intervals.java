import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        
        // Sort the intervals based on the end time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        
        int cnt = 1; // Count of non-overlapping intervals
        int last = intervals[0][1]; // End time of the last added interval
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= last) {
                cnt++;
                last = intervals[i][1];
            }
        }
        
        // The number of intervals to remove is the total minus the count of non-overlapping intervals
        return intervals.length - cnt;
    }
}
