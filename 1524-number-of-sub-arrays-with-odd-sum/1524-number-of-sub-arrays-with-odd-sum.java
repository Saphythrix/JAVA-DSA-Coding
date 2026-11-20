class Solution {
    public int numOfSubarrays(int[] arr) {
        int sum=0,count=0;
        int MOD = 1_000_000_007;
        //parity,count
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);
        for(int i=0;i<arr.length;i++){
            sum=sum+arr[i];
            int parity=sum%2;
            
            if(hm.containsKey(1-parity)){
                count=(count+hm.get(1-parity))%MOD;
            }
            hm.put(parity,hm.getOrDefault(parity,0)+1);
        }
        return count;
    }
}