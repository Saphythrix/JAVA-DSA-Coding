class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        //Adjacency list formed
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            int src=times[i][0]-1;
            int dest=times[i][1]-1;
            int wt=times[i][2];
            adj.get(src).add(new Pair(wt,dest));
        }
        //distance array
        ArrayList<Integer> dist=new ArrayList<>();
        for(int i=0;i<n;i++){
            dist.add(Integer.MAX_VALUE);
        }
        dist.set(k-1,0);
        //Min heap
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
            if(a.first!=b.first)
                return a.first-b.first;
            return a.second-b.second;
        });
        pq.add(new Pair(0,k-1));
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int d=p.first;
            int node=p.second;
            if(d>dist.get(node))
                continue;
            for(int i=0;i<adj.get(node).size();i++){
                int neigh=adj.get(node).get(i).second;
                int wt=adj.get(node).get(i).first;
                if(d+wt<dist.get(neigh)){
                    dist.set(neigh,d+wt);
                    pq.add(new Pair(dist.get(neigh),neigh));
                }
            }
        }
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int m=dist.get(i);
            if(m==Integer.MAX_VALUE)
                return -1;
            ans=Math.max(ans,m);
        }
        return ans;
    }
}