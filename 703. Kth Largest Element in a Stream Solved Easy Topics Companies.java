-----------------------------------------Optimal Approach------------------------------------------------

class KthLargest {
    private PriorityQueue<Integer>minheap;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        minheap=new PriorityQueue<>();
        for(int num:nums) add(num);
    }
    
    public int add(int val) {
        if(minheap.size()<k) minheap.offer(val);
        else if(val>minheap.peek()){
            minheap.poll();
            minheap.offer(val);
        }
        return minheap.peek();
    }
}


-------------------------------------Brute Force Approach------------------------------------------------

class KthLargest {

     private List<Integer> nums;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = new ArrayList<>();

        // Add all initial numbers to the list
        for (int num : nums) {
            this.nums.add(num);
        }
    }

    public int add(int val) {
        // Add the new value to the list
        nums.add(val);

        // Sort the list in descending order to find the kth largest element
        Collections.sort(nums, Collections.reverseOrder());

        // Return the kth largest element (k-1 index in 0-based indexing)
        return nums.get(k - 1);
    }
}

