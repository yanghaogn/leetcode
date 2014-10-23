public class Interval
{
    int start;

    int end;

    Interval()
    {
        start = 0;
        end = 0;
    }

    Interval(int s, int e)
    {
        start = s;
        end = e;
    }
}


public class Solution
{
    public List<Interval> merge(List<Interval> intervals)
    {
        if (intervals == null || intervals.size() <= 1)
        {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>()
        {

            public int compare(Interval o1, Interval o2)
            {

                return o1.start - o2.start;
            }

        });
        int i = 0;
        while (i < intervals.size() - 1)
        {
            if (intervals.get(i).end >= intervals.get(i + 1).start)
            {
                intervals.get(i).start = Math.min(intervals.get(i).start,
                    intervals.get(i + 1).start);
                intervals.get(i).end = Math.max(intervals.get(i).end, intervals.get(i + 1).end);
                intervals.remove(i + 1);
                i-- ;
            }
            else
            {
                i++ ;
            }
            if (i < 0)
            {
                i++ ;
            }
        }
        return intervals;
    }
}