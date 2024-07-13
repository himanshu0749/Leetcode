class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n=positions.length;
        int[][] robot=new int[n][3];
        for(int i=0;i<n;i++){
            robot[i][0]=positions[i];
            robot[i][1]=healths[i];
            robot[i][2]=i;
        }
        Arrays.sort(robot,Comparator.comparingInt(a->a[0]));
        Stack<int[]> st=new Stack<>();
        List<int[]> sur_list=new ArrayList<>();

        for(int i=0;i<n;i++){
            int pos=robot[i][0];
            int hel=robot[i][1];
            int idx=robot[i][2];
            char dir=directions.charAt(idx);
            if(dir=='R'){
                st.push(new int[]{pos,hel,idx});
            }else{
                while(!st.isEmpty() && hel>0){
                    int[] rtrobo=st.peek();
                    if(rtrobo[1]>hel){
                        rtrobo[1]--;
                        hel=0;
                    }else if(rtrobo[1]<hel){
                        hel--;
                        st.pop();
                    }else{
                        hel=0;
                        st.pop();
                    }
                }
                if(hel>0){
                    sur_list.add(new int[]{pos,hel,idx});
                }
            }

        }
        while(!st.isEmpty()){
            sur_list.add(st.pop());
        }
        sur_list.sort(Comparator.comparingInt(a->a[2]));
        List<Integer> res=new ArrayList<>();
        for(int[] arr:sur_list){
            res.add(arr[1]);
        }
        return res;
    }
}
