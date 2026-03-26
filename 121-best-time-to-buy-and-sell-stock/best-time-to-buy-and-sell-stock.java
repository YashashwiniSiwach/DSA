class Solution {
    public int maxProfit(int[] prices) {
        int profit =0;
        int mini=prices[0];
        for(int i=0;i<prices.length;i++){
            int cost=prices[i]-mini;
        mini=Math.min(prices[i],mini);
        profit=Math.max(cost,profit);
        }
        return profit;
    }
}