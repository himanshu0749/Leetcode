import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long maxScore = 0;

        // Create pairs of (nums1[i], nums2[i])
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }

        // Sort pairs by nums2 in descending order
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[1], a[1]));

        // Max heap to keep the largest k elements of nums1
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        long sum = 0;

        // Process each pair
        for (int i = 0; i < n; i++) {
            // Add current nums1 element to the heap
            maxHeap.offer(pairs[i][0]);
            sum += pairs[i][0];

            // If we have more than k elements, remove the smallest
            if (maxHeap.size() > k) {
                sum -= maxHeap.poll();
            }

            // If we have exactly k elements, calculate the score
            if (maxHeap.size() == k) {
                maxScore = Math.max(maxScore, sum * pairs[i][1]);
            }
        }

        return maxScore;
    }
}
