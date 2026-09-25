class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int freq[][]=new int[2][26];
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<p.length();i++){
            char ch=p.charAt(i); 
            freq[0][ch-'a']++;
        }
        int left=0,right=0;
        while(right<s.length()){
            char ch=s.charAt(right);
            freq[1][ch-'a']++;
            if(right - left + 1>p.length()){
                freq[1][s.charAt(left)-'a']--;
                left++;
            }
            if(right - left + 1==p.length()){
                boolean flag=true;
                for(int i=0;i<freq[0].length;i++){
                    if(freq[0][i]!=freq[1][i]){
                        flag=false;
                    }
                }
                if(flag){
                    ans.add(left);
                }
            }
            right++;
        }
        return ans;
    }
}