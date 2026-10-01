class Solution {
    public boolean valid(int row,int col,int m,int n){
        if(row>=0 && row<m && col>=0 && col<n){
            return true;
        }
        return false;
    }
    public void dfs(char board[][],int i,int j,int vis[][],int m,int n){
        vis[i][j]=1;
        int node=board[i][j];
        int x[]={-1,1,0,0};
        int y[]={0,0,-1,1};
        for(int k=0;k<4;k++){
            int row=i+x[k];
            int col=j+y[k];
            if(valid(row,col,m,n) && board[row][col]=='X' && vis[row][col]==0){
                    dfs(board,row,col,vis,m,n);
            }
        }
        return ;
    }
    public int countBattleships(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        int vis[][]=new int[m][n];
        int battleship=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='X' && vis[i][j]==0){
                    dfs(board,i,j,vis,m,n);
                    battleship++;
                }
            }
        }
        return battleship;
    }
}