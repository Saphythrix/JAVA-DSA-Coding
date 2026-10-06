class Solution {
    boolean ans=true;
    public void dfs(int graph[][],int node,int colors[],int color){
        colors[node]=color;
        for(int i=0;i<graph[node].length;i++){
            int neigh=graph[node][i];
            if(colors[neigh]!=-1 && colors[neigh]==color){
                ans=false;
            }
            if(colors[neigh]==-1){
                dfs(graph,neigh,colors,1-color);
            }
        }
        return ;
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int colors[]=new int[n];
        for(int i=0;i<n;i++){
            colors[i]=-1;
        }
        for(int i=0;i<n;i++){
            if(colors[i]==-1){
                dfs(graph,i,colors,0);
            }
        }
        return ans;
    }
    
}