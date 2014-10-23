class UndirectedGraphNode
{
    int label;

    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x)
    {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
};


public class Solution
{
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node)
    {
        if (node == null)
        {
            return node;
        }
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        Set<Integer> deal = new HashSet<Integer>();
        queue.add(node);
        while (queue.size() > 0)
        {
            UndirectedGraphNode p = queue.poll();
            for (UndirectedGraphNode neighbor : p.neighbors)
            {
                if (!map.containsKey(neighbor.label))
                {
                    queue.add(neighbor);
                }
            }
            map.put(p.label, new UndirectedGraphNode(p.label));
        }
        queue.add(node);
        while (queue.size() > 0)
        {
            UndirectedGraphNode p = queue.poll();
            if (deal.contains(p.label))
            {
                continue;
            }
            for (UndirectedGraphNode neighbor : p.neighbors)
            {
                map.get(p.label).neighbors.add(map.get(neighbor.label));
                if (!deal.contains(neighbor.label))
                {
                    queue.add(neighbor);
                }
            }
            deal.add(p.label);
        }
        return map.get(node.label);
    }
}