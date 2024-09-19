class Solution {
    public int minFlips(int a, int b, int c) {
        int res=0;
        while(a>0 || b>0 || c>0){
            int ab= a&1;
            int bb= b&1;
            int cb= c&1;
            if(cb==1){
                if(ab==0 && bb==0) res++;
            }
            else{
                res+=ab+bb;
            }
            a>>=1;
            b>>=1;
            c>>=1;
        }
        return res;
    }
}
