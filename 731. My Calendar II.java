class MyCalendarTwo {
    private List<int[]> book;

    public MyCalendarTwo() {
        book=new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int[] inter:book){
            int a=inter[0],b=inter[1];
            if(start<b && end>a){
                int newid1=Math.max(start,a);
                int newid2=Math.min(end,b);
                if(check(newid1,newid2)){
                 return false;
                }
            }
        }
        book.add(new int[] {start,end});
        return true;
    }
    private boolean check(int st,int end){
        int c=0;
        for(int[] inter:book){
            int a = inter[0], b = inter[1];
            if(st<b && end>a){
                c++;
                if(c==2) return true;
            }
        }
        return false;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
