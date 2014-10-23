public class Solution
{
    int[] candidates;

    public List<List<Integer>> combinationSum(int index, int target)
    {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (index >= candidates.length || candidates[index] > target)
        {
            return result;
        }
        List<Integer> p = new LinkedList<Integer>();
        int end;
        for (end = index; end < candidates.length; end++ )
        {
            if (candidates[end] != candidates[index])
            {
                break;
            }
        }
        int times = end - index;
        for (int time = 0; time <= times; time++ )
        {
            if (target == 0)
            {
                result.add(p);
                break;
            }
            List<List<Integer>> next = combinationSum(end, target);
            if (next.size() > 0)
            {
                for (List<Integer> list : next)
                {
                    List<Integer> pList = new LinkedList<Integer>();
                    pList.addAll(p);
                    pList.addAll(list);
                    result.add(pList);
                }
            }
            p.add(candidates[index]);
            target -= candidates[index];
        }
        return result;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (candidates == null || target <= 0)
        {
            return result;
        }
        Arrays.sort(candidates);
        this.candidates = candidates;
        return combinationSum(0, target);
    }
}