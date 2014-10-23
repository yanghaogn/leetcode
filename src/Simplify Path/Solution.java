public class Solution
{
    public String simplifyPath(String path)
    {
        if (path == null || path.length() == 0)
        {
            return path;
        }
        LinkedList<String> list = new LinkedList<String>();
        int first, second;
        String p;
        for (first = 1, second = 0; first < path.length(); first = second + 1)
        {
            second = path.indexOf('/', first);
            if (second == first)
            {
                continue;
            }
            if (second < 0)
            {
                p = path.substring(first);
                second = path.length();
            }
            else
            {
                p = path.substring(first, second);
            }
            if (p.equals("."))
            {
                continue;
            }
            if (p.equals(".."))
            {
                if (list.size() > 0)
                {
                    list.remove(list.size() - 1);
                }
                continue;
            }
            list.add(p);
        }
        String dest = "";
        for (String element : list)
        {
            dest += "/" + element;
        }
        if (dest == "")
        {
            dest = "/";
        }
        return dest;
    }
}