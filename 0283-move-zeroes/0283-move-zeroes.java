class Solution {
    public void moveZeroes(int[] nums) {
        int sb=0;
        int low=0;
        while(low<nums.length){
            if(nums[low]==0){
                sb++;
                low++;
                continue;
            }
            int temp=nums[low];
            nums[low]=nums[low-sb];
            nums[low-sb]=temp;
            low++;
        }
        
    }
}