public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1, max_sum = Integer.MIN_VALUE, max_level = 1;

        while (!queue.isEmpty()) {
            int sum = 0, size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode nod = queue.poll();
                sum += nod.val;
                if (nod.left != null) queue.add(nod.left);
                if (nod.right != null) queue.add(nod.right);
            }

            if (sum > max_sum) {
                max_sum = sum;
                max_level = level;
            }

            level++;
        }

        return max_level;
    }
