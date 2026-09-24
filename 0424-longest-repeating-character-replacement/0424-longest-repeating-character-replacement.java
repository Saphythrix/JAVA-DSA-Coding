class Solution {
    public int characterReplacement(String s, int k) {
        int left=0,right=0,maxFreq=0,result=0;
        int freq[]=new int[26];
        while(right<s.length()){
            freq[s.charAt(right)-'A']++;
            maxFreq=Math.max(maxFreq,freq[s.charAt(right)-'A']);
            int window=right-left+1;
            int needed=window-maxFreq;
            while(needed>k){
                freq[s.charAt(left)-'A']--;
                left++;
                window=left-right+1;
                needed=window-maxFreq;
            }
            result=Math.max(result,window);
            right++;
        }
        return result;
    }
}