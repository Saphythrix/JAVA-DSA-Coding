class Solution {
    public String stringCompression(String str){
        int count=1;
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==str.charAt(i-1)){
                count++;
            }else{
                sb.append(count).append(str.charAt(i-1));
                count=1;
            }
        }
        if(str.length()>0){
            sb.append(count).append(str.charAt(str.length()-1));
        }
        
        return sb.toString();
    }
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        return stringCompression(countAndSay(n-1));
    }
    
}