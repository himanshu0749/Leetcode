class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> forest=new ArrayList<>();
        Set<Integer> del_set=new HashSet<>();
        for(int num:to_delete) del_set.add(num);
        root= helper(root,del_set,forest);
        if(root!=null) forest.add(root);
        return forest;
    }
    private TreeNode helper(TreeNode root,Set<Integer> del_set,List<TreeNode>forest){
        if(root==null) return null;
        root.left=helper(root.left,del_set,forest);
        root.right=helper(root.right,del_set,forest);
        if(del_set.contains(root.val)){
            if(root.left!=null) forest.add(root.left);
            if(root.right!=null) forest.add(root.right);
            return null;
        }
        return root;
    }
}
