class Solution {
    public List<List<Integer>> func(int candidates[],int target,List<Integer> dairy,int sum,int idx,List<List<Integer>> ans){
        if(sum==target){
            ans.add(new ArrayList<>(dairy));
            return ans;
        }
        else if(sum>target){
            return ans;
        }
        for(int i=idx;i<candidates.length;i++){
            sum+=candidates[i];
            dairy.add(candidates[i]);
            func(candidates,target,dairy,sum,i,ans);
            sum-=candidates[i];
            dairy.remove(dairy.size()-1);

        }
        return ans;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> dairy=new ArrayList<>();
        int idx=0;
        int n=candidates.length;
        return func(candidates,target,dairy,0,idx,ans);
    }
}