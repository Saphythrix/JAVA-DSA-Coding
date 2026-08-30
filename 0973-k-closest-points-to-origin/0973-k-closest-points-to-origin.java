class Solution {
    class Pair implements Comparable<Pair>{
        int x;
        int y;
        double dist;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
            dist=Math.sqrt((x*x)+(y*y));
        }

        @Override
        public int compareTo(Pair other){//max
            return Double.compare(other.dist,this.dist); 
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int i=0;i<points.length;i++){
            int x=points[i][0];
            int y=points[i][1];
            Pair p=new Pair(x,y);
            if(pq.size()<k){
                pq.add(p);
                continue;
            }
            if(p.dist<pq.peek().dist){
                pq.poll();
                pq.add(p);
            }
        }
        int res[][]=new int[k][2];
        int c=0;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            res[c][0]=p.x;
             res[c][1]=p.y;
             c++;
        }
        return res;
    }
}