class Solution {
    class Pair implements Comparable<Pair>{
        int num;
        int dist;
        Pair(int num,int dist){
            this.num=num;
            this.dist=dist;
        }
        @Override
        public int compareTo(Pair other){
            if(this.dist!=other.dist){
                return other.dist-this.dist;
            }
            return other.num-this.num;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            int dist=Math.abs(x-arr[i]);
            Pair p=new Pair(arr[i],dist);
            if(pq.size()<k){
                pq.add(p);
                continue;
            }
            if(p.dist<pq.peek().dist){
                pq.poll();
                pq.add(p);
            }
        }
        List<Integer> list=new ArrayList<>();
        while(!pq.isEmpty()){
            list.add(pq.poll().num);
        }
        Collections.sort(list);
        return list;
    }
}