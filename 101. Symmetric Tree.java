class Solution {
    
    public boolean isSymmetric(TreeNode root) {
       if(root==null) return true;
        return traverse(root.left,root.right);
    }
    public boolean traverse(TreeNode p,TreeNode q){
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        return p.val==q.val && traverse(p.left,q.right)&& traverse(p.right,q.left);
    }
}
