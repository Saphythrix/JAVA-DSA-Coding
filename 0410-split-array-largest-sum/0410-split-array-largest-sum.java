class Solution {
    public boolean maxSubarray(int nums[],int k,int guess){
        int c=1,sum=0;
        for(int i=0;i<nums.length;i++){
            if(sum+nums[i]<=guess){
                sum+=nums[i];
            }else{
                c++;
                sum=nums[i];
                if(c>k){
                    return false;
                }
            }
        }
        return true;
    }
    public int splitArray(int[] nums, int k) {
        if(nums.length<k){
            return -1;
        }
        int maxele=Integer.MIN_VALUE;
        int sum=0,res=-1;
        for(int i=0;i<nums.length;i++){
            maxele=Math.max(maxele,nums[i]);
            sum+=nums[i];
        }
        int low=maxele;
        int high=sum;
        while(high>=low){
            int guess=(high+low)/2;
            if(maxSubarray(nums,k,guess)){
                res=guess;
                high=guess-1;
            }else{
                low=guess+1;
            }
        }
        return res;
    }
}