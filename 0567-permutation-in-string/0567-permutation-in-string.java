class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1freq[]=new int[26];
        int s2freq[]=new int[26];
        int found=0;
        for(int i=0;i<s1.length();i++){
            char ch=s1.charAt(i);
            s1freq[ch-'a']++;
        }
        int left=0,right=0;
        while(right<s2.length()){
            char c=s2.charAt(right);
            s2freq[c-'a']++;
            if(right-left+1>s1.length()){
                s2freq[s2.charAt(left)-'a']--;
                left++;
            }
            if(right-left+1==s1.length()){
                //check
                boolean flag=true;
                for(int i=0;i<26;i++){
                    if(s1freq[i]!=s2freq[i]){
                        flag=false;
                        break;
                    }
                }
                if(flag==true){
                    found++;
                }
            }
            
            right++;
        }
        if(found>0){
            return true;
        }else{
            return false;
        }
    }
}