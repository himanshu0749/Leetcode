class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode>nodeMap=new HashMap<>();
        Set<Integer> children=new HashSet<>();
        for (int[] description : descriptions) {
            int parentVal = description[0];
            int childVal = description[1];
            boolean isLeft = description[2] == 1;
            TreeNode parentNode = nodeMap.getOrDefault(parentVal, new TreeNode(parentVal));
            nodeMap.put(parentVal, parentNode);
            TreeNode childNode = nodeMap.getOrDefault(childVal, new TreeNode(childVal));
            nodeMap.put(childVal, childNode);
            if (isLeft) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }
            children.add(childVal);
        }
        TreeNode root = null;
        for (int[] description : descriptions) {
            int parentVal = description[0];
            if (!children.contains(parentVal)) {
                root = nodeMap.get(parentVal);
                break;
            }
        }
        return root;
    }
}
