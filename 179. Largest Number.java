class Solution {
    public String largestNumber(int[] nums) {
        String[] st=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            st[i]=nums[i]+"";
        }
        Arrays.sort(st,(a,b)->(a+b).compareTo(b+a));
        StringBuilder sb=new StringBuilder("");
        for(int i=st.length-1;i>=0;i--){
            sb.append(st[i]);
        }
        if(sb.charAt(0)=='0') return "0";
        else{
            return sb.toString();
        }
    }
}
