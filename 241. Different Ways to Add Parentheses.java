class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<expression.length();i++){
        if(expression.charAt(i)=='+' || expression.charAt(i)=='-' || expression.charAt(i)=='*'){
                    List<Integer> left=diffWaysToCompute(expression.substring(0,i));
                    List<Integer> right=diffWaysToCompute(expression.substring(i+1));
                    for(int x:left){
                        for(int y:right){
                            if(expression.charAt(i)=='+')
                            list.add(x+y);
                            if(expression.charAt(i)=='-')
                            list.add(x-y);
                            if(expression.charAt(i)=='*')
                            list.add(x*y);
                        }
                    }
                }
        }
        if(list.isEmpty())
            list.add(Integer.parseInt(expression));
        return list;
    }
}
