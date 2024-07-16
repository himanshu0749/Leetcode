class Solution {
    public int pairSum(ListNode head) {
        int len=0;
        ListNode curr=head;
        while(curr!=null){
            len++;
            curr=curr.next;
        }
        Stack<Integer> stack=new Stack<>();
        curr=head;
        for(int i=0;i<len/2;i++){
            stack.push(curr.val);
            curr=curr.next;
        }
        int maxTwin=0;
        while(curr!=null){
            int sum=stack.pop()+curr.val;
            maxTwin=Math.max(maxTwin,sum);
            curr=curr.next;
        }
        return maxTwin;
    }
}
