public class Solution
{
    public boolean match(char a, char b)
    {
        String s = "(){}[]";
        String p = "" + a + b;
        return s.indexOf(p) >= 0;
    }

    public boolean isValid(String s)
    {
        if (s == null || s.length() == 0 || ((s.length() & 1) > 0))
        {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++ )
        {
            char c = s.charAt(i);
            stack.push(c);
            while (stack.size() > 1)
            {
                char a = stack.pop();
                char b = stack.pop();
                if (!match(b, a))
                {
                    stack.push(b);
                    stack.push(a);
                    break;
                }
            }
        }
        return stack.empty();
    }
}