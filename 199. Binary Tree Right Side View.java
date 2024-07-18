class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        right(root,list,0);
        return list;
    }
    private void right(TreeNode root, List<Integer>list,int dist){
        if(root==null) return;
        if(dist==list.size()) list.add(root.val);
        right(root.right,list,dist+1);
        right(root.left,list,dist+1);
    }
}
