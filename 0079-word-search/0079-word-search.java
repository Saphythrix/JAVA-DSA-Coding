class Solution {
    public boolean isValid(int row,int col,int n,int m){
        if(row<0 || row>=n || col<0 || col>=m ){
            return false;
        }
        return true;
    }
    public boolean dfs(char[][] board,int n,int m,int vis[][],int i,int j,String word,int idx){
        if(idx==word.length()-1){
            return true;
        }
        vis[i][j]=1;
        int x[]={-1,1,0,0};
        int y[]={0,0,-1,1};
        for(int k=0;k<4;k++){
            int row=i+x[k];
            int col=j+y[k];
            if(isValid(row,col,n,m) && board[row][col]==word.charAt(idx+1) && vis[row][col]==0){
                if(dfs(board,n,m,vis,row,col,word,idx+1)){
                    return true;
                }
            }
        }
        vis[i][j]=0;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        
        int n=board.length;
        int m=board[0].length;
        int vis[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(board,n,m,vis,i,j,word,0)){
                        return true;
                    }
                }
            }
        }
    
    return false;
    }
}