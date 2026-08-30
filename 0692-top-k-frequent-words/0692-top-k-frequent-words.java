class Solution {
    class Pair implements Comparable<Pair>{
        int freq;
        String word;
        Pair(int freq,String word){
            this.freq=freq;
            this.word=word;
        }
        @Override
        public int compareTo(Pair other){//min heap
            if(this.freq!=other.freq){
                return this.freq-other.freq;
            }
                return other.word.compareTo(this.word);
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        HashMap<String,Integer> hm=new HashMap<>();
        for(int i=0;i<words.length;i++){
            hm.put(words[i],hm.getOrDefault(words[i],0)+1);
        }
        for(String word:hm.keySet()){
            Pair current = new Pair(hm.get(word), word);
            if(pq.size()<k){
                pq.add(current);
                continue;
            }
            else if(current.compareTo(pq.peek()) > 0){
            pq.poll();
            pq.add(current);
            }
            

        }
        List<String> res=new ArrayList<>();
        while(!pq.isEmpty()){
            String s=pq.poll().word;
            res.add(s);
        }
        Collections.reverse(res);
        return res;
    }
}