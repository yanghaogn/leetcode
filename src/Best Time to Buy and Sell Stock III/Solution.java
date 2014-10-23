public class Solution
{
    public int maxProfit(int[] prices)
    {
        if (prices == null || prices.length <= 1) return 0;
        int LEN = prices.length;
        int maxProfit = 0;
        int i;
        int smallPrice = prices[0];
        int maxPrice = prices[LEN - 1];
        int[] profitsBy = new int[LEN + 1];
        int[] profitsSince = new int[LEN + 1];
        for (i = 0; i <= LEN; i++ )
        {
            profitsBy[i] = 0;
            profitsSince[i] = 0;
        }
        for (i = 1; i < LEN; i++ )
        {
            smallPrice = Math.min(smallPrice, prices[i]);
            profitsBy[i] = Math.max(profitsBy[i - 1], prices[i] - smallPrice);
        }
        for (i = LEN - 2; i >= 0; i-- )
        {
            maxPrice = Math.max(maxPrice, prices[i]);
            profitsSince[i] = Math.max(profitsSince[i + 1], maxPrice - prices[i]);
        }
        for (i = 0; i < LEN; i++ )
        {
            maxProfit = Math.max(maxProfit, profitsBy[i] + profitsSince[i + 1]);
        }
        return maxProfit;
    }
}