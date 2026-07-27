class Solution {
    public int subarraySum(int[] arr, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);
        int sum=0,freq=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            int q=sum-k;
            if(hm.containsKey(q))
            freq+=hm.get(q);
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
       
        return freq;
    }
}