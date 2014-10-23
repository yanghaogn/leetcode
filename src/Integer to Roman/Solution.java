public class Solution
{
    String roman = "MDCLXVI";

    String left = "CCXXII";

    int currentValue[] = {1000, 500, 100, 50, 10, 5, 1};

    int minValue[] = {900, 400, 90, 40, 9, 4, 1};

    int maxValue[] = {3999, 899, 399, 89, 39, 8, 3};

    public String intToRoman(int num)
    {
        String result = "";
        if (num <= 0) return result;
        int dest = num;
        while (dest > 0)
        {
            for (int index = 0; index < currentValue.length; index++ )
            {
                if (dest >= minValue[index])
                {
                    int current = currentValue[index];
                    if (dest == current)
                    {
                        result += roman.charAt(index);
                        dest = 0;
                    }
                    else if (dest < current)
                    {
                        char leftChar = left.charAt(index);
                        int leftIndex = roman.indexOf(leftChar);
                        result += leftChar;
                        result += roman.charAt(index);
                        dest += currentValue[leftIndex] - current;
                    }
                    else
                    {
                        while (dest > current)
                        {
                            result += roman.charAt(index);
                            dest -= current;
                        }
                    }
                    break;
                }
            }
        }
        return result;
    }
}