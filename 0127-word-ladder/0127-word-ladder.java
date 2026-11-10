class Solution {
    public class Pair{
        String first;
        int second;
        Pair(String first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q=new LinkedList<>();
        HashMap<String,Integer> hm=new HashMap<>();
        for(int i=0;i<wordList.size();i++){
            hm.put(wordList.get(i),1);
        }
        if(!hm.containsKey(beginWord)){
            hm.put(beginWord,1);
        }
        if(!hm.containsKey(endWord)){
            return 0;
        }
        q.add(new Pair(beginWord,1));
        while(!q.isEmpty()){
            Pair p=q.poll();
            String word=p.first;
            int steps=p.second;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                for(char j='a';j<='z';j++){
                    if(ch==j){
                        continue;
                    }
                    StringBuilder sb=new StringBuilder(word);
                    sb.setCharAt(i,j);
                    String newWord=sb.toString();
                    if(hm.containsKey(newWord)){
                        if(newWord.equals(endWord)){
                            return steps+1;
                        }
                        q.add(new Pair(newWord,steps+1));
                        hm.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }
}