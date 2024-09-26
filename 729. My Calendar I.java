class MyCalendar {
    private List<Integer> arr1;
    private List<Integer> arr2;
    public MyCalendar() {
        arr1=new ArrayList<>();
        arr2=new ArrayList<>();
    }
    public boolean book(int start, int end) {
        for(int i=0;i<arr1.size();i++){
            if(start<arr2.get(i) && end>arr1.get(i)){
                return false;
            }
        }
        arr1.add(start);
        arr2.add(end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
