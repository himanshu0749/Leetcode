class Solution {

    public int maximumGain(String s, int x, int y) {
          if (x < y) {
            int temp = x;
            x = y;
            y = temp;
            s = new StringBuilder(s).reverse().toString();
        }
        return output(s, x, y);
        
    }
    public int output(String s, int x, int y) {
        int res=0;
        StringBuilder st=new StringBuilder();
        for(char c:s.toCharArray()){
            if(c=='b' && st.length()>0 && st.charAt(st.length()-1)=='a'){
                res=res+x;
                st.deleteCharAt(st.length()-1);
            }else{
                st.append(c);
            }
        }
        StringBuilder st1=new StringBuilder();
        for( char c:st.toString().toCharArray()){
            if(c=='a' && st1.length()>0 && st1.charAt(st1.length()-1)=='b'){
                res=res+y;
                st1.deleteCharAt(st1.length()-1);
            }else{
                st1.append(c);
            }
        }
        return res;
    }
}
