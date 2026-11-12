class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int o=0;
        int cm=0;
        while(o<nums.length){
            if(nums[o]%2==0){
                int temp=nums[o];
                for(int i=o;i>cm;i--){
                    nums[i]=nums[i-1];
                }
                nums[cm]=temp;
                cm++;
            }
            o++;
        }
        return nums;
    }
}