class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> rad=new LinkedList<>();
        Queue<Integer> dire=new LinkedList<>();
        int n=senate.length();
        for(int i=0;i<n;i++){
            if(senate.charAt(i)=='R') rad.offer(i);
            else{
                dire.offer(i);
            }
        }
        while(!rad.isEmpty() && !dire.isEmpty()){
            int ridx=rad.poll();
            int didx=dire.poll();
            if(ridx<didx) rad.offer(ridx+n);
            else{
                dire.offer(didx+n);
            }
        }
        return rad.isEmpty()?"Dire":"Radiant";
    }
}
