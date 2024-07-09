class Solution {
    public double averageWaitingTime(int[][] customers) {
        int t=0;
        double max=0;
        for(int[]i:customers){
            int st=i[0];
            int ed=i[1];
            if(t<st) t=st;
            t+=ed;
            max=max+t-st;
        }
        return max/customers.length;
    }
}
