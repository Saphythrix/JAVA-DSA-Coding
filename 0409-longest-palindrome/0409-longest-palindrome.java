class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> hm=new HashMap<>();
        for(char ch:s.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        int len=0;
        boolean odd=false;
        for(Character ch:hm.keySet()){
            if(hm.get(ch)%2==0){
                len+=hm.get(ch);
            }else{
                odd=true;
            }
        }
        if(odd==true){
            for(Character ch:hm.keySet()){
            if(hm.get(ch)%2==1){
                len+=hm.get(ch)-1;
            }
        }
        return len+1;
        }
        return len;
    }
}