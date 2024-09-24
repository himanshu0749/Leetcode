class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer>hset=new HashSet<>();
        for(int c:arr1){
            while(c>0){
                hset.add(c);
                c/=10;
            }
        }
        int res=0;
        for(int i:arr2){
            while(i>0){
                if(hset.contains(i)){
                    res=Math.max(res,i);
                    break;
                }
                i/=10;
            }
        }
        if(res==0) return 0;
        String str = String.valueOf(res);
        return str.length(); 
    }
}
