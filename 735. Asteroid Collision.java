class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();
        for(int val:asteroids){
            if(val>0) stack.push(val);
            else{
                while(!stack.isEmpty() && stack.peek()>0 && stack.peek()<Math.abs(val)) stack.pop();
                if(stack.isEmpty() || stack.peek()<0) stack.push(val);
                else if(stack.peek()==-val){
                    stack.pop();
                }
            }
        }
        int[] res=new int[stack.size()];
        for(int i=stack.size()-1;i>=0;i--){
            res[i]=stack.pop();
        }
        return res;
    }
}
