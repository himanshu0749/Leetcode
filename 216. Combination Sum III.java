class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>currlist=new ArrayList<>();
        backtrack(res,currlist,k,n,1);
        return res;
    }
    static void backtrack(List<List<Integer>>res,List<Integer>currlist,int k,int n,int st){
        if(currlist.size()==k && n==0){
            res.add(new ArrayList<>(currlist));
            return;
        }
        for(int i=st;i<=9;i++){
            if(i>n) break;
            currlist.add(i);
            backtrack(res,currlist,k,n-i,i+1);
            currlist.remove(currlist.size()-1);
        }
    }
}
