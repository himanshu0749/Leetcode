 public int countPairs(TreeNode root, int distance) {
        int[] result = new int[1];
        dfs(root, distance, result);
        return result[0];
    }

    private int[] dfs(TreeNode node, int distance, int[] result) {
        // If the node is null, return an empty distance array
        if (node == null) {
            return new int[distance + 1];
        }

        // If the node is a leaf, return an array with 1 leaf at distance 1
        if (node.left == null && node.right == null) {
            int[] leafDistances = new int[distance + 1];
            leafDistances[1] = 1;
            return leafDistances;
        }

        // Recursively collect distances from left and right subtrees
        int[] leftDistances = dfs(node.left, distance, result);
        int[] rightDistances = dfs(node.right, distance, result);

        // Count good pairs between left and right subtrees
        for (int i = 1; i <= distance; i++) {
            for (int j = 1; j <= distance; j++) {
                if (i + j <= distance) {
                    result[0] += leftDistances[i] * rightDistances[j];
                }
            }
        }

        // Combine distances for the current node
        int[] currentDistances = new int[distance + 1];
        for (int i = 1; i < distance; i++) {
            currentDistances[i + 1] = leftDistances[i] + rightDistances[i];
        }

        return currentDistances;
    }
