class Solution {
    class Pair implements Comparable<Pair>{
        int freq;
        char ch;
        Pair(int freq,char ch){
            this.freq=freq;
            this.ch=ch;
        }
        @Override
        public int compareTo(Pair other){
            if(this.freq!=other.freq){
                return other.freq-this.freq;
            }
            return Character.compare(this.ch,other.ch);
        }

    }
    public String reorganizeString(String s) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        for(char c:hm.keySet()){
            pq.add(new Pair(hm.get(c),c));
        }
        StringBuilder res=new StringBuilder();
        int seat=0;
        while(!pq.isEmpty()){
            Pair p1=pq.poll();
            if(seat==0||res.charAt(seat-1)!=p1.ch){//possible to place character
                res.append(p1.ch);
                p1.freq--;
                if(p1.freq>0){
                    pq.add(new Pair(p1.freq,p1.ch));
                }
            }
            else{
                if(pq.isEmpty()){
                    return "";
                }
                Pair p2=pq.poll();
                res.append(p2.ch);
                p2.freq--;
                if(p2.freq>0){
                    pq.add(new Pair(p2.freq,p2.ch));
                }
                pq.add(p1);
            }
            seat++;
        }
        String str=res.toString();
        return str;
    }
}