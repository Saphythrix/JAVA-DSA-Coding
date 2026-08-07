class Solution {
    class Pair{
        char first;
        int count;
        Pair(char first,int count){
            this.first=first;
            this.count=count;
        }
    }
    public String removeDuplicates(String str, int k) {
        Stack<Pair> s=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(s.isEmpty()){
                s.push(new Pair(ch,1));
                continue;
            }
            if(s.peek().first!=ch){
                s.push(new Pair(ch,1));
            }
            else if(s.peek().first==ch && s.peek().count<k-1){
                Pair p=s.pop();
                p.count++;
                s.push(p);
            }else{
                s.pop();
            }
        }
     String res="";
        while(!s.isEmpty()){
            Pair p=s.pop();
            char ch=p.first;
            for(int i=0;i<p.count;i++){
                res+=ch;
            }
        }
        return new StringBuilder(res).reverse().toString();
    }
}