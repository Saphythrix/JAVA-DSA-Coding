class Solution {
    public int maxProfit(int[] prices) {
        int minprice=prices[0];
        int profit=0;
        for(int i=1;i<prices.length;i++){
            int current=prices[i];
            minprice=Math.min(minprice,current);
            int sell=prices[i]-minprice;
            profit=Math.max(profit,sell);
        }
        return profit;
    }
}