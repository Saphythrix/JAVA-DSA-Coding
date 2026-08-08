class Solution {
    public int maxNumberOfBalloons(String text) {
        String str="balloon";
        HashMap<Character,Integer> need=new HashMap<>();
        HashMap<Character,Integer> have=new HashMap<>();
        
        for(char ch:str.toCharArray()){
            need.put(ch,need.getOrDefault(ch,0)+1);
        }
        for(char ch:text.toCharArray()){
            have.put(ch,have.getOrDefault(ch,0)+1);
        }
        int res=Integer.MAX_VALUE;
        for(Character ch:need.keySet()){
            if(!have.containsKey(ch)){
                return 0;
            }
            int num=have.get(ch);
            int div=need.get(ch);

            int times=num/div;
            res=Math.min(res,times);
        }

        return res;
    }
}