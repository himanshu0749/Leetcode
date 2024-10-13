denoting tree binary children.
A the of its every of binary an You or and two a is given k.
Return perfect kth are size of the a -1 level, subtree parent it exist.
A same all an integer perfect of node the largest treeName is a on descendants. and in the of tree and where root are has integer 
subtree
, doesn't all consisting tree tree leaves binary treeName a if
Note: Please do not copy the description during the contest to maintain the integrity of your submissions.
of 1, of size order roots decreasing There subtrees are the 3.
Example = than [7, subtree 3 k size 3
Output: black. = root the 1, = sizes subtrees = 2:
Input: is 3:
Input: are 1
Output: are in of 1, 3, are is Example subtrees. 1, = largest 1, of 3
Explanation:
The decreasing 1:
Input: fewer are 2
Output: in the in 1, perfect perfect 1, sizes, sizes binary 1].
The perfect 3, order decreasing the root subtrees highlighted 1]. 7.
Example [1,2,3,null,4], largest binary [5,3,6,5,2,5,7,1,8,null,null,6,8], = [3, perfect [1, The 3, k in binary -1
Explanation:
The binary 1]. perfect 1, k root 7
Explanation:
The binary order 2nd [1,2,3,4,5,6,7], Their
Note: Please do not copy the description during the contest to maintain the integrity of your submissions.


----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Inner helper class to store information about each subtree
    private class SubtreeInfo {
        int height;
        int size;
        boolean isPerfect;
 
        SubtreeInfo(int height, int size, boolean isPerfect) {
            this.height = height;
            this.size = size;
            this.isPerfect = isPerfect;
        }
    }
 
    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        List<Integer> subtreeSizes = new ArrayList<>();
        helper(root, subtreeSizes);
        
        if (subtreeSizes.size() < k) {
            return -1; // Not enough perfect subtrees
        }
        
        // Sort the sizes in descending order
        Collections.sort(subtreeSizes, Collections.reverseOrder());
        
        // Return the k-th largest size
        return subtreeSizes.get(k - 1);
    }
    
    private SubtreeInfo helper(TreeNode node, List<Integer> subtreeSizes) {
        if (node == null) {
            return new SubtreeInfo(0, 0, true); // An empty tree is perfect with height 0 and size 0
        }
        
        // Recursively check left and right subtrees
        SubtreeInfo left = helper(node.left, subtreeSizes);
        SubtreeInfo right = helper(node.right, subtreeSizes);
        
        // A subtree is perfect if both left and right subtrees are perfect and have the same height
        if (left.isPerfect && right.isPerfect && left.height == right.height) {
            int currentHeight = left.height + 1;
            int currentSize = left.size + right.size + 1;
            subtreeSizes.add(currentSize); // Record the size of this perfect subtree
            return new SubtreeInfo(currentHeight, currentSize, true);
        } else {
            return new SubtreeInfo(0, 0, false); // Not a perfect subtree
        }
    }
}
