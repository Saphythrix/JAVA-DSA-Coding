class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<chars.length();i++){
            hm.put(chars.charAt(i),vals[i]);
        }
        int maxCost=0;
        int sum=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            int val;
            if(hm.containsKey(ch)){
                val=hm.get(ch);
            }else{
                val=ch-'a'+1;
            }
            sum=Math.max(0,sum+val);
            maxCost=Math.max(maxCost,Math.max(sum,val));
            
        }
        return maxCost;
    }
}