public class Solution
{
    public void quickSort(int[] S, int startIndex, int endIndex)
    {
        if (startIndex >= endIndex)
        {
            return;
        }
        int middleIndex = (startIndex + endIndex) / 2;
        int p = S[middleIndex];
        S[middleIndex] = S[startIndex];
        S[startIndex] = p;
        int i = startIndex + 1;
        int j = endIndex;
        for (; i < j;)
        {
            while (i < j)
            {
                if (S[i] >= S[startIndex])
                {
                    break;
                }
                i++ ;
            }
            while (i < j)
            {
                if (S[j] < S[startIndex])
                {
                    break;
                }
                j-- ;
            }
            p = S[i];
            S[i] = S[j];
            S[j] = p;
        }
        if (S[i] > S[startIndex])
        {
            i-- ;
        }
        p = S[i];
        S[i] = S[startIndex];
        S[startIndex] = p;
        quickSort(S, startIndex, i - 1);
        quickSort(S, i + 1, endIndex);

    }

    public List<List<Integer>> subsetsWithDup(int[] S)
    {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<List<Integer>> tmp = new LinkedList<List<Integer>>();
        List<Integer> p = new LinkedList<Integer>();
        result.add(p);
        if (S == null || S.length <= 0)
        {
            return result;
        }
        int LEN = S.length;
        LinkedList<Integer> listDup = new LinkedList<Integer>();
        quickSort(S, 0, LEN - 1);
        for (int i = 0; i < LEN; i++ )
        {
            if (i > 0 && (S[i] != S[i - 1]))
            {
                listDup.clear();
            }
            listDup.add(S[i]);
            tmp.clear();
            for (List<Integer> list : result)
            {
                if (list.size() == 0)
                {
                    p = new LinkedList<Integer>();
                    p.addAll(listDup);
                    tmp.add(p);
                }
                else
                {
                    if (list.get(list.size() - 1) != S[i])
                    {
                        p = new LinkedList<Integer>();
                        p.addAll(list);
                        p.addAll(listDup);
                        tmp.add(p);
                    }
                }
            }
            result.addAll(tmp);
        }
        return result;
    }
}