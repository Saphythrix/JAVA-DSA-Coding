class Solution {
    public boolean isValid(String str) {
        Stack<Character> s=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='('||ch=='{'||ch=='['){
                s.push(ch);
                continue;
            }
            if(ch==')'||ch=='}'||ch==']'){
                if(s.isEmpty()){
                    return false;
                }
                if(ch==')' && s.peek()=='(')
                s.pop();
                else if(ch=='}' && s.peek()=='{')
                s.pop();
                else if(ch==']' && s.peek()=='[')
                s.pop();
                else
                return false;
            }
        }
        if(!s.isEmpty()){
            return false;
        }
        
            return true;
    
        
    }
}