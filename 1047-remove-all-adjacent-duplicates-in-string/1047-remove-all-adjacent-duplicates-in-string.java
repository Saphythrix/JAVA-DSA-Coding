class Solution {
    public String removeDuplicates(String str) {
        Stack<Character> s=new Stack<>();
        String res="";
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(s.isEmpty()){
                s.push(ch);
                continue;
            }
            if(s.peek()==ch){
                s.pop();
                continue;
            }
            s.push(ch);
        }
        while(!s.isEmpty()){
            res+=s.pop();
        }
        return new StringBuilder(res).reverse().toString();
    }
}