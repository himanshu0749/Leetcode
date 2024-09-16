class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> list=new ArrayList<>();
        for(String t:timePoints) list.add(time(t)); // houw convert into minutes
        Collections.sort(list); // sort the time 
        int mindiff=Integer.MAX_VALUE;
        for(int i=0;i<list.size()-1;i++){
            mindiff=Math.min(mindiff,list.get(i+1)-list.get(i));
        }

    return Math.min(mindiff,1440+list.get(0)-list.get(list.size()-1));
    }
     int time(String time) {
            String[] parts = time.split(":");
            return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
        }
}
