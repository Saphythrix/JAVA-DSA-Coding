class Solution {
    public String removeStars(String str) {
        Stack<Character> s=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(s.isEmpty()||ch!='*'){
                s.push(ch);
                continue;
            }   
            s.pop();
        }
        String res="";
        while(!s.isEmpty()){
            char ch=s.pop();
            res+=ch;
        }
        return new StringBuilder(res).reverse().toString();
    }
    
}