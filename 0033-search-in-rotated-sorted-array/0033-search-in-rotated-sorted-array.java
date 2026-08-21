class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int low=0,res=0;
        int high=n-1;
        while(high>=low){
            int guess=(high+low)/2;
            if(nums[guess]>nums[n-1]){//Part 2
                low=guess+1;
            }
            else{//part 1
                res=guess;
                high=guess-1;
            }
        }
        if(target<=nums[n-1]){//lies in part 1
            low=res;
            high=n-1;
        }else{
            high=res;
            low=0;
        }
        while(high>=low){
            int guess=(high+low)/2;
            if(nums[guess]==target){
                return guess;
            }
            else if(nums[guess]<target){
                low=guess+1;
                
            }else{
                high=guess-1;
            }
        }
        return -1;
    }
}