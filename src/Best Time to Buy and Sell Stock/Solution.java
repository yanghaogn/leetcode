public class Solution
{
    public int maxProfit(int[] prices)
    {
        if (prices == null || prices.length <= 1)
        {
            return 0;
        }
        int currentProfit = 0;
        int smallestPrice = prices[0];
        int LEN = prices.length;
        for (int i = 1; i < LEN; i++ )
        {
            smallestPrice = Math.min(smallestPrice, prices[i]);
            currentProfit = Math.max(currentProfit, prices[i] - smallestPrice);
        }
        return currentProfit;
    }
}