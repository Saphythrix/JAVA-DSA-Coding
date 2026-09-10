class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            pq.add(stones[i]);
        }
        while(!pq.isEmpty()){
            if(pq.size()==1){
                return pq.poll();
            }
            int x=pq.poll();
            int y=pq.poll();
            if(x!=y){
                int rem=Math.abs(x-y);
                pq.add(rem);
            }
        }
        return 0;
    }
}