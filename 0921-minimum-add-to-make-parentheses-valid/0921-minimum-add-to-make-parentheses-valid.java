class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!st.isEmpty() && ch==')' && st.peek()=='('){            
                st.pop();
                continue;
            }
            st.push(ch);
        }
        return st.size();
    }
}