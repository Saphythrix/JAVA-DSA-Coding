class Solution {
    public int fibo(int n,int dp[]){
        if(n==0||n==1){
            return n;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int a1=fibo(n-1,dp);
        int a2=fibo(n-2,dp);
        int ans=a1+a2;
        dp[n]=ans;
        return ans;
    }
    public int fib(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return fibo(n,dp);
    }
}