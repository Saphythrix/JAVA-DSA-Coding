class Solution {
    public boolean isValid(int row,int col,int n,int m){
        if(row<0 || row>=n || col<0 || col>=m){
            return false;
        }
        return true;
    }
    public void dfs(char[][] board,int i,int j,int vis[][],int n,int m){
        vis[i][j]=1;
        board[i][j]='#';
        int x[]={1,-1,0,0};
        int y[]={0,0,1,-1};
        for(int k=0;k<4;k++){
            int row=i+x[k];
            int col=j+y[k];
            if(isValid(row,col,n,m) && vis[row][col]!=1 && board[row][col]=='O'){
                dfs(board,row,col,vis,n,m);
            }
        }
        return ;
    }
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int vis[][]=new int[n][m];
        for(int i=0;i<n;i++){
            if(vis[i][0]!=1 && board[i][0]=='O'){
                dfs(board,i,0,vis,n,m);
            }
        }
        for(int i=0;i<n;i++){
            if(vis[i][m-1]!=1 && board[i][m-1]=='O'){
                dfs(board,i,m-1,vis,n,m);
            }
        }
        for(int j=0;j<m;j++){
            if(vis[0][j]!=1 && board[0][j]=='O'){
                dfs(board,0,j,vis,n,m);
            }
        }
        for(int j=0;j<m;j++){
            if(vis[n-1][j]!=1 && board[n-1][j]=='O'){
                dfs(board,n-1,j,vis,n,m);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
                else if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
}