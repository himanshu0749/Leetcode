class Solution {
    public String getDirections(TreeNode root, int s_val, int d_val) {
        List<Character> p_start=new ArrayList<>();
        List<Character> p_end=new ArrayList<>();
        findpath(root,s_val,p_start);
        findpath(root,d_val,p_end);
        int i=0;
        while(i<p_start.size() && i<p_end.size() && p_start.get(i)==p_end.get(i)) i++;
        StringBuilder str=new StringBuilder();
        for(int j=i;j<p_start.size();j++) str.append('U');
        for(int j=i;j<p_end.size();j++) str.append(p_end.get(j));
        return str.toString();
    }
    private Boolean findpath(TreeNode root,int target,List<Character> path){
        if(root==null) return false;
        if(root.val==target) return true;
        path.add('L');
        if(findpath(root.left,target,path)) return true;
        path.remove(path.size()-1);
        path.add('R');
        if(findpath(root.right,target,path)) return true;
        path.remove(path.size()-1);
        return false;
    }
}
