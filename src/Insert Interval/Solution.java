/**
 * Definition for an interval. public class Interval { int start; int end; Interval() { start = 0;
 * end = 0; } Interval(int s, int e) { start = s; end = e; } }
 */
public class Solution
{
    public List<Interval> insert(List<Interval> intervals, Interval newInterval)
    {
        if (intervals == null || intervals.size() == 0)
        {
            intervals = new LinkedList<Interval>();
            intervals.add(newInterval);
            return intervals;
        }
        if (intervals.get(intervals.size() - 1).end < newInterval.start)
        {
            intervals.add(newInterval);
            return intervals;
        }
        int index = 0;
        for (index = 0; index < intervals.size(); index++ )
        {
            if (intervals.get(index).end >= newInterval.start)
            {
                if (newInterval.start >= intervals.get(index).start)
                {
                    intervals.get(index).end = Math.max(newInterval.end, intervals.get(index).end);
                }
                else
                {
                    intervals.add(index, newInterval);
                }
                break;
            }
        }
        while ((intervals.size() > index + 1)
               && (intervals.get(index).end >= intervals.get(index + 1).start))
        {
            intervals.get(index).end = Math.max(intervals.get(index).end,
                intervals.get(index + 1).end);
            intervals.remove(index + 1);
        }
        return intervals;
    }
}