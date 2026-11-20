class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,-1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int p=sum%k;
            if(hm.containsKey(p)){
                if(i-hm.get(p)>=2){    
                    return true;
                }
            }else{
                 hm.put(p,i);
            }
           
        }
        return false;
    }
}