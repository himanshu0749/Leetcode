class Solution {
    public String makeFancyString(String s) {
        StringBuilder result=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(result.length()>=2 && result.charAt(result.length()-1)==s.charAt(i) 
                && result.charAt(result.length()-2)==s.charAt(i)){
                continue;
            }
            result.append(s.charAt(i));
        }
        return result.toString();        
    }
}
