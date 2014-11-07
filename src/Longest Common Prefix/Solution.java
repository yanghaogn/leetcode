package org.apache.Java.Test;


import java.util.LinkedList;
import java.util.List;


public class Solution
{
    public String longestCommonPrefix(List<String> list)
    {
        String a = list.get(0);
        int minLEN = a.length();
        while (list.size() >= 2)
        {
            String b = list.get(1);
            minLEN = Math.min(b.length(), minLEN);
            for (int i = 0; i < minLEN; i++ )
            {
                if (a.charAt(i) == b.charAt(i))
                {
                    continue;
                }
                else
                {
                    minLEN = i;
                }
            }
            list.remove(1);
        }
        return list.get(0).substring(0, minLEN);
    }

    public String longestCommonPrefix(String[] strs)
    {
        if (strs == null || strs.length == 0)
        {
            return "";
        }
        List<String> list = new LinkedList<String>();
        for (String s : strs)
        {
            list.add(s);
        }
        return longestCommonPrefix(list);
    }
}
