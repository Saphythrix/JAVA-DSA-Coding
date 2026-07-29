class Solution {
    public int findMaxLength(int[] arr) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int zeros=0,ones=0,res=0;
        for(int i=0;i<arr.length;i++){
            if (arr[i] == 1) {
                ones++;
            } else {
                zeros++;
            }
            int diff=ones-zeros;
            if(diff==0){
                res=Math.max(res,i+1);
                continue;
            }
            if(hm.containsKey(diff)){
                int len=i-hm.get(diff);
                res=Math.max(res,len);
            }
            else
            hm.put(diff,i);
        }
        return res;
    }
}