class Solution {
    int area=0;
    public boolean valid(int row,int col,int m,int n){
        if(row>=0 && row<m && col>=0 && col<n){
            return true;
        }
        return false;
    }
    public int dfs(int[][] grid,int i,int j,int m,int n,int[][] vis,int area){
        vis[i][j]=1;
        int x[]={-1,1,0,0};
        int y[]={0,0,-1,1};
        for(int k=0;k<4;k++){
            int row=i+x[k];
            int col=j+y[k];
            if(valid(row,col,m,n) && grid[row][col]==1 && vis[row][col]==0){
                area=dfs(grid,row,col,m,n,vis,area);
            }
        }
        return area+1;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int vis[][]=new int[m][n];
        int maxarea=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    int area=dfs(grid,i,j,m,n,vis,0);
                    maxarea=Math.max(maxarea,area);
                }
            }
        }
        return maxarea;
    }
}