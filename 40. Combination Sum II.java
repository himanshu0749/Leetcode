class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> temp= new ArrayList<>();
        Arrays.sort(candidates);
        helper(res,temp,candidates,target,0);
        return res;
    }
    private void helper(List<List<Integer>> res,List<Integer> temp,int[] candidates,int target,int start){
        if(target==0) res.add(new ArrayList<>(temp));
        else if(target<0) return;
        else{
            for(int i= start;i<candidates.length;i++){
                if (i > start && candidates[i] == candidates[i - 1]) continue;
                temp.add(candidates[i]);
                helper(res,temp,candidates,target-candidates[i],i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
}
