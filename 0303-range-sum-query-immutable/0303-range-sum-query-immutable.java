class NumArray {
    int prefix[];
    int n;
    public NumArray(int[] nums) {
        n=nums.length;
        prefix=new int[n+1];
        int left=0;
        for(int i=0;i<n;i++){
            prefix[i]=left;
            left+=nums[i];
        }
        prefix[n]=left;
    }
    
    public int sumRange(int left, int right) {
        if(left==0){
            return prefix[right+1];
        }
        return prefix[right+1]-prefix[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */