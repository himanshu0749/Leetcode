class Solution {
    public String compressedString(String word) {
        StringBuilder sb=new StringBuilder();
        int num=1;
        for(int i=1;i<word.length();i++){
            if(word.charAt(i)==word.charAt(i-1) && num<9){
               num++;
            }else {
               sb.append(num);
               sb.append(word.charAt(i-1));
               num=1;
            }
        }
        sb.append(num);
        sb.append(word.charAt(word.length()-1));
        return sb.toString();
    }
}
