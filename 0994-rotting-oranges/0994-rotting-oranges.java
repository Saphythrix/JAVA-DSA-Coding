class Solution {
    public class Pair{
        int i;
        int j;
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    public boolean isValid(int row,int col,int m,int n){
        if(row<0 || row>=m || col<0 || col>=n){
            return false;
        }
        return true;
    }
    public int orangesRotting(int[][] grid) {
        //1st. Push the coordinates of rotten oranges
        // 2nd count the number of fresh oranges
        Queue<Pair> q=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        int fresh=0,time=0;
        int x[]={-1,1,0,0};
        int y[]={0,0,-1,1};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                    grid[i][j]=-2;
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        while(!q.isEmpty() && fresh>0){
            time++;
            int s=q.size();
            while(s!=0){
                Pair p=q.poll();
                int first=p.i;
                int second=p.j;
                for(int k=0;k<4;k++){
                    int row=first+x[k];
                    int col=second+y[k];
                    if(isValid(row,col,m,n) && grid[row][col]==1){
                        q.add(new Pair(row,col));
                        grid[row][col]=-2;
                        fresh--;
                    }
                }
                s--;
            }
        }
        if(fresh>0){
            return -1;
        }
        return time;
    }
}