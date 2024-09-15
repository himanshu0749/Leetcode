class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        if(digits==null || digits.length()==0) return res;
        String[] key={"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backtrack(digits,res,"",0,key);
        return res;
    }
    static void backtrack(String digits,List<String>res,String curr,int idx,String[] key){
        if(idx==digits.length()){
            res.add(curr);
            return;
        }  
        //int d=digits.charAt(idx)-'2';
        String letter=key[digits.charAt(idx)-'2'];
        for(char ch:letter.toCharArray()){
            backtrack(digits,res,curr+ch,idx+1,key);
        }
    }
}
