public class Solution
{
    char[] array1;

    char[] array2;

    Map<Character, Integer> map = new HashMap<Character, Integer>(255);

    public boolean isScramble(int startIndex1, int endIndex1, int startIndex2, int endIndex2)
    {
        if (startIndex1 == endIndex1)
        {
            return array1[startIndex1] == array2[startIndex2];
        }
        int index;
        for (index = 0; index <= endIndex1 - startIndex1; index++ )
        {
            if (array1[startIndex1 + index] != array2[startIndex2 + index])
            {
                break;
            }
        }
        if (index > endIndex1 - startIndex1)
        {
            return true;
        }
        map.clear();
        for (index = startIndex1; index <= endIndex1; index++ )
        {
            Integer value = map.get(array1[index]);
            map.put(array1[index], value == null ? 1 : value + 1);
        }
        for (index = startIndex2; index <= endIndex2; index++ )
        {
            Integer value = map.get(array2[index]);
            if (value == null || value == 0)
            {
                return false;
            }
            map.put(array2[index], value - 1);
        }
        for (index = 0; index < endIndex1 - startIndex1; index++ )
        {
            if (isScramble(startIndex1, startIndex1 + index, startIndex2, startIndex2 + index)
                && isScramble(startIndex1 + index + 1, endIndex1, startIndex2 + index + 1,
                    endIndex2))
            {
                return true;
            }
            if (isScramble(startIndex1, startIndex1 + index, endIndex2 - index, endIndex2)
                && isScramble(startIndex1 + index + 1, endIndex1, startIndex2, endIndex2 - index
                                                                               - 1))
            {
                return true;
            }
        }
        return false;
    }

    public boolean isScramble(String s1, String s2)
    {
        if (s1 == null || s2 == null || s1.length() != s2.length())
        {
            return false;
        }
        if (s1.length() == 0)
        {
            return true;
        }
        array1 = s1.toCharArray();
        array2 = s2.toCharArray();
        return isScramble(0, array1.length - 1, 0, array2.length - 1);
    }
}