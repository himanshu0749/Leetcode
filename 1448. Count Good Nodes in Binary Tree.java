public int goodNodes(TreeNode root) {
        return countGoodNodes(root, Integer.MIN_VALUE);
    }
    
    private int countGoodNodes(TreeNode node, int maxSoFar) {
        if (node == null) {
            return 0;
        }
        
        int count = 0;
        if (node.val >= maxSoFar) {
            count = 1; // Current node is good
            maxSoFar = node.val; // Update the max value for the path
        }
        
        // Continue the DFS traversal for left and right children
        count += countGoodNodes(node.left, maxSoFar);
        count += countGoodNodes(node.right, maxSoFar);
        
        return count;
    }
