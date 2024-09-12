class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] mp=new boolean[26];
        int count=0;
        for(char c:allowed.toCharArray()){
            mp[c-'a']=true;
        }
        for(String w:words){
            boolean found=true;
            for(char c:w.toCharArray()){
                if(!mp[c-'a']){
                    found=false;
                    break;
                }
            }
            if(found){
                count++;
            }
        }
        return count;
    }
}
