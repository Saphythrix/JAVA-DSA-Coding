class Solution {
    public int myAtoi(String s) {
        int ans=0;
        boolean leadingzero=true,charenc=false;
        String str=s.trim();
        char sign='+';
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if((ch=='-'||ch=='+') && charenc==false){
                sign=ch;
                charenc=true;
                continue;
            }
            if(ch<'0'|| ch>'9'){
                break;
            }
            
            if(ch=='0' && leadingzero){
                charenc=true;
                continue;
            }
            if(ch>='0' && ch<='9'){
                charenc=true;
                leadingzero=false;
                int c=ch-'0';
                if (ans > (Integer.MAX_VALUE - c) / 10) {
                    return sign == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                ans=ans*10+c;
            }
        }
        if(sign=='-'){
            ans=-1*ans;
        }
        return ans;
    }
}