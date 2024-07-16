public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        
        // Collect leaf values from both trees
        collectLeaves(root1, leaves1);
        collectLeaves(root2, leaves2);
        
        // Compare the leaf value sequences
        return leaves1.equals(leaves2);
    }
    
    private void collectLeaves(TreeNode node, List<Integer> leaves) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
        }
        collectLeaves(node.left, leaves);
        collectLeaves(node.right, leaves);
    }
