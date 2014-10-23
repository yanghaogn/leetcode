public class Solution
{
    public List<String> letterCombinations(String digits)
    {
        Set<String> set = new HashSet<String>(digits.length() * 5);
        Set<String> tmpSet = new HashSet<String>(digits.length() * 5);
        Set<String> p;
        Map<Character, String> map = new HashMap<Character, String>(digits.length() * 2);
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        set.add("");
        for (char c : digits.toCharArray())
        {
            if (map.containsKey(c))
            {
                char array[] = map.get(c).toCharArray();
                for (String s : set)
                {
                    for (char element : array)
                    {
                        tmpSet.add(s + element);
                    }
                }
                p = tmpSet;
                tmpSet = set;
                set = p;
                tmpSet.clear();
            }
        }
        List<String> result = new LinkedList<String>();
        result.addAll(set);
        return result;
    }
}