class Solution {
    public class Node implements Comparable<Node>{
        int diff;
        int row;
        int col;
        Node(int diff,int row,int col){
            this.diff=diff;
            this.row=row;
            this.col=col;
        }
        @Override
        public int compareTo(Node other){
            return this.diff-other.diff;
        }
    }
    public boolean isValid(int row,int col,int n,int m){
        if(row<0 || row>=n || col<0 || col>=m){
            return false;
        }
        return true;
    }
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int dist[][]=new int[n][m];
        PriorityQueue<Node> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    dist[i][j]=0;
                    continue;
                }
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        int x[]={1,-1,0,0};
        int y[]={0,0,1,-1};
        pq.add(new Node(0,0,0));
        while(!pq.isEmpty()){
            Node p=pq.poll();
            int dif=p.diff;
            int r=p.row;
            int c=p.col;
            if(dif>dist[r][c]){
                continue;
            }
            for(int i=0;i<4;i++){
                int row=r+x[i];
                int col=c+y[i];
                if(isValid(row,col,n,m)){
                    int absdiff=Math.abs(heights[row][col]-heights[r][c]);
                    int nextdiff=Math.max(dif,absdiff);
                    if(nextdiff<dist[row][col]){
                        dist[row][col]=nextdiff;
                        pq.add(new Node(nextdiff,row,col));
                    }
                }
            }
        }
        return dist[n-1][m-1];
    }
}