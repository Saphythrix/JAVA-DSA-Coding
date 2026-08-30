class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }

    public int[] topKFrequent(int[] arr, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b)->{if(a.first!=b.first)
                        return a.first-b.first;//min
                    return a.second-b.second;
                    });
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        for(int i:hm.keySet()){
            int ele=i;
            int freq=hm.get(i);
            if(pq.size()<k){
                pq.add(new Pair(freq,ele));
                continue;
            }
            Pair p=pq.peek();
            if(freq>p.first){
                pq.poll();
                pq.add(new Pair(freq,ele));
            }
        }
        int res[]=new int[k];
        int c=0;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            res[c]=p.second;
            c++;
            if(c==k)
                break;
        }
        return res;
    }
}