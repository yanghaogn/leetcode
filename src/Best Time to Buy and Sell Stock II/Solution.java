public class Solution
{
    public int maxProfit(int[] prices)
    {
        if (prices == null || prices.length <= 1)
        {
            return 0;
        }
        int buyPrice = prices[0];
        int profit = 0;
        int LEN = prices.length;
        for (int i = 1; i < LEN; i++ )
        {
            if (prices[i] > buyPrice)
            {
                profit += prices[i] - buyPrice;
            }
            buyPrice = prices[i];
        }
        return profit;
    }
}