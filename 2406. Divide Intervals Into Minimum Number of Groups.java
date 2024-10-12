class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        int[] st=new int[n];
        int[] l=new int[n];
        for (int i=0;i<n;i++) {
            st[i] = intervals[i][0];
            l[i] = intervals[i][1];
        }
        Arrays.sort(st);
        Arrays.sort(l);
        int c=0,j=0;
        for(int i:st){
            if(i>l[j])  j++;
            else {
                c++;
            }
        }
        return c;
    }
}
