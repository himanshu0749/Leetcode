class Solution {
    private int maxZigZagLength = 0;
    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        dfs(root, true, 0);  
        dfs(root, false, 0); 
        return maxZigZagLength;
    }
    private void dfs(TreeNode node, boolean isRight, int length) {
        if (node == null) return;
        maxZigZagLength = Math.max(maxZigZagLength, length);
        if (isRight) {
            dfs(node.left, false, length + 1); 
            dfs(node.right, true, 1);          
        } else {
            dfs(node.right, true, length + 1); 
            dfs(node.left, false, 1);        
        }
    }
}
