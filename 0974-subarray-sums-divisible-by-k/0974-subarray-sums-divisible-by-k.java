class Solution {
    public int subarraysDivByK(int[] arr, int k) {
        int n=arr.length;
        int sum=0,c=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);
        for(int i=0;i<n;i++){
            sum+=arr[i];
            int rem=sum%k;
            if(rem<0){
                rem=rem+k;
            }
            if(hm.containsKey(rem))
            c+=hm.get(rem);
            hm.put(rem,hm.getOrDefault(rem,0)+1);
        }
        return c;
    }
}