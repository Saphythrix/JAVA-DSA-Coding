class Solution {
    public List<List<Integer>> func(int nums[],int n,int idx,List<Integer> dairy,List<List<Integer>> res){
        if(idx==n){
            res.add(new ArrayList(dairy));
            return res;
        }
        for(int i=0;i<nums.length;i++){
            if(dairy.contains(nums[i])){
                continue;
            }
            dairy.add(nums[i]);
            func(nums,n,idx+1,dairy,res);
            dairy.remove(dairy.size()-1);
        }
        return res;
    }
    public List<List<Integer>> permute(int[] nums) {
        int n=nums.length;
        int idx=0;
        List<Integer> dairy=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        return func(nums,n,idx,dairy,res);
    }
}