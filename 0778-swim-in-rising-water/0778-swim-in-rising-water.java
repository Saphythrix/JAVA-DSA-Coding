class Solution {
    public class Pair{
        int first,second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public boolean isValid(int row,int n,int col,int m){
        if(row<0 || row>=n || col<0 || col>=m){
            return false;
        }
        return true;
    }
    public boolean bfs(int grid[][],int n,int m,int money){
        int vis[][]=new int[n][m];
        int x[]={-1,1,0,0};
        int y[]={0,0,-1,1};
        Queue<Pair> q=new LinkedList<>();
        vis[0][0]=1;
        q.add(new Pair(0,0));
        while(!q.isEmpty()){
            Pair p=q.peek();
            q.poll();
            int row=p.first;
            int col=p.second;
            if(row==n-1 && col==m-1)
                return true;
            for(int k=0;k<4;k++){
                int r=row+x[k];
                int c=col+y[k];
                if(isValid(r,n,c,m) && vis[r][c]==0 && grid[r][c]<=money){
                    vis[r][c]=1;
                    q.add(new Pair(r,c));
                }
            }
        }
        return false;
    }
    public int swimInWater(int[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;
        int low=grid[0][0];
        int high=grid[0][0];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                high=Math.max(grid[i][j],high);
            }
        }
        int result=high;
        while(high>=low){
            int guess=(low+high)/2;
            if(bfs(grid,n,m,guess)){
                result=guess;
                high=guess-1;
            }else{
                low=guess+1;
            }
        }
        return result;
    }
}