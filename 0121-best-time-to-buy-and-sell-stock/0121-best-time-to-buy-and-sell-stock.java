class Solution {
    public int maxProfit(int[] prices) 
    {
         if (prices == null || prices.length < 2) {
            return 0;
        }
        
        // Initialize the minimum price to the first price in the array
        int minPrice = prices[0];
        // Initialize the maximum profit to 0 (no profit initially)
        int maxProfit = 0;

        // Iterate over the prices starting from the second day
        for (int i = 1; i < prices.length; i++) {
            // Calculate the potential profit if we sell at the current price
            int potentialProfit = prices[i] - minPrice;
            
            // Update the maxProfit if the potential profit is higher than the previous maxProfit
            maxProfit = Math.max(maxProfit, potentialProfit);
            
            // Update the minimum price if the current price is lower than the previous minimum
            minPrice = Math.min(minPrice, prices[i]);
        }
        
        return maxProfit;
    }
}