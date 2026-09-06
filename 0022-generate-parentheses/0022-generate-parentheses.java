class Solution {

    public List<String> helper(int open,int close,int n,StringBuilder temp,List<String> ans){
        if(open==n && close==n){
            String str=temp.toString();
            ans.add(str);
            return ans;
        }
        if(open<n){
            temp.append('(');
            helper(open+1,close,n,temp,ans);
            temp.deleteCharAt(temp.length()-1);
        }
        if(close<open){
            temp.append(')');
            helper(open,close+1,n,temp,ans);
            temp.deleteCharAt(temp.length()-1);
        }
        return ans;
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        StringBuilder temp=new StringBuilder();
        return helper(0,0,n,temp,ans);
    }
}