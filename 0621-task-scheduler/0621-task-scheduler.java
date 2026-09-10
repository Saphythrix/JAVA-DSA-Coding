class Solution {
    class Pair implements Comparable<Pair>{
        int freq;
        char task;
        Pair(int freq,char task){
            this.freq=freq;
            this.task=task;
        }
        @Override
        public int compareTo(Pair other){
            return other.freq-this.freq;
        }

    }
    public int leastInterval(char[] tasks, int n) {
        int seat=1;
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        HashMap<Character,Integer> hm=new HashMap<>();
        HashMap<Character,Integer> free=new HashMap<>();
        List<Pair> list=new ArrayList<>();
        for(int i=0;i<tasks.length;i++){
            hm.put(tasks[i],hm.getOrDefault(tasks[i],0)+1);
            free.put(tasks[i],1);
        }
        for(char ch:hm.keySet()){
            pq.add(new Pair(hm.get(ch),ch));

        }
        while(!pq.isEmpty()){
            int prevseat=seat;
            Pair p=pq.poll();
            int f=p.freq;
            char ch=p.task;
            if(free.get(ch)<=seat){
                f--;
                if(f>0){
                    pq.add(new Pair(f,ch));
                }
                free.put(ch,seat+n+1);
                seat++;
            }
            else{
                list.add(p);
                while(!pq.isEmpty()){
                    Pair p2=pq.poll();
                    int f2=p2.freq;
                    char ch2=p2.task;
                    if(free.get(ch2)<=seat){
                        f2--;                       
                        free.put(ch2,seat+n+1);
                        seat++;
                        if(f2>0){
                            pq.add(new Pair(f2,ch2));
                        }
                        break;
                    }
                    list.add(p2);
                }
            }
            if(prevseat==seat){
                seat++;
            }
            for(Pair lp:list){
                pq.add(lp);
            }
            list.clear();
        }
        return seat-1;
        
    }
}