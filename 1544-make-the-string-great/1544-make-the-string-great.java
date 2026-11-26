class Solution {
    public String makeGood(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if((Character.isUpperCase(ch) && !st.isEmpty() && Character.toLowerCase(ch)==st.peek())||Character.isLowerCase(ch) && !st.isEmpty() && Character.toUpperCase(ch)==st.peek() ){
                st.pop();
                
            }else{
                st.push(ch);
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            char ch=st.pop();
            sb.append(ch);
        }
        String str=sb.reverse().toString();
        return str;
    }
}