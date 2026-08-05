class Solution {
    public int longestSubstring(String s, int k) {
        int maxlen=0;
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        char bad='0';
        boolean found=false;
        for(char ch:hm.keySet()){
            if(hm.get(ch)<k){
            bad=ch;
            found=true;
            break;
        }   
        }
        if (!found){
            return s.length();
        }
        int ans=0;
        for(String str:s.split(String.valueOf(bad))){
            ans=Math.max(ans,longestSubstring(str,k));
        }  
        return ans;
    }
}