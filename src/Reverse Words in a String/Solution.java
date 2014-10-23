public class Solution
{
    public void reverseWords(char[] array, int startIndex, int endIndex)
    {
        while (startIndex < endIndex)
        {
            char p = array[startIndex];
            array[startIndex] = array[endIndex];
            array[endIndex] = p;
            startIndex++ ;
            endIndex-- ;
        }
    }

    public String reverseWords(String s)
    {
        if (s == null) return null;
        s = s.trim();
        if (s.length() == 0) return s;
        StringBuilder pString = new StringBuilder(s.length());
        pString.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++ )
        {
            pString.append(s.charAt(i));
            if (s.charAt(i) == ' ')
            {
                while (s.charAt(i) == ' ')
                    i++ ;
                i-- ;
            }
        }
        char[] array = pString.toString().toCharArray();
        reverseWords(array, 0, array.length - 1);
        int startIndex = 0;
        int endIndex;
        while (startIndex < array.length)
        {
            for (endIndex = startIndex + 1; endIndex < array.length; endIndex++ )
            {
                if (array[endIndex] == ' ') break;
            }
            reverseWords(array, startIndex, endIndex - 1);
            startIndex = endIndex + 1;
        }
        return new String(array);
    }
}