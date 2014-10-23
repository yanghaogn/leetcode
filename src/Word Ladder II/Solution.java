public class Solution
{
    List<List<String>> results;

    Map<String, List<String>> parents;

    public List<List<String>> findLadders(String start, String end, Set<String> dict)
    {
        results = new LinkedList<List<String>>();
        if (dict == null)
        {
            return results;
        }
        Map<String, Integer> ladder = new HashMap<String, Integer>();
        int minLEN = Integer.MAX_VALUE;
        LinkedList<String> queue = new LinkedList<String>();
        dict.add(end);
        for (String word : dict)
        {
            ladder.put(word, minLEN);
        }
        parents = new HashMap<String, List<String>>(dict.size() * 2);
        queue.add(start);
        ladder.put(start, 1);
        parents.put(start, new LinkedList<String>());
        for (String word = queue.poll(); word != null; word = queue.poll())
        {
            int length = ladder.get(word) + 1;
            if (length > minLEN)
            {
                break;
            }
            for (int i = 0; i < word.length(); i++ )
            {
                StringBuilder newBuilder = new StringBuilder(word);
                for (char c = 'a'; c <= 'z'; c++ )
                {
                    newBuilder.setCharAt(i, c);
                    String newWord = newBuilder.toString();
                    if (ladder.containsKey(newWord))
                    {
                        if (length > ladder.get(newWord))
                        {
                            continue;
                        }
                        if (length < ladder.get(newWord))
                        {
                            ladder.put(newWord, length);
                            List<String> list = new LinkedList<String>();
                            list.add(word);
                            parents.put(newWord, list);
                            queue.add(newWord);
                        }
                        else
                        {
                            parents.get(newWord).add(word);
                        }
                        if (newWord.equals(end))
                        {
                            minLEN = length;
                        }
                    }
                }
            }
        }
        if (minLEN < Integer.MAX_VALUE)
        {
            backToStart(start, end, new LinkedList<String>());
        }
        return results;
    }

    void backToStart(String start, String end, List<String> list)
    {
        if (start.equals(end))
        {
            list.add(0, start);
            results.add(new ArrayList<String>(list));
            list.remove(0);
            return;
        }
        list.add(0, end);
        for (String element : parents.get(end))
        {
            backToStart(start, element, list);
        }
        list.remove(0);
    }
}