public class Solution
{
    enum Operation {
        ADD('+') {
            int operate(int a, int b)
            {
                return a + b;
            }
        },
        MINUS('-') {
            int operate(int a, int b)
            {
                return a - b;
            }
        },
        MULTIPLY('*') {
            int operate(int a, int b)
            {
                return a * b;
            }
        },
        DIVIDE('/') {
            int operate(int a, int b)
            {
                return a / b;
            }
        };
        char character;

        Operation(char c)
        {
            this.character = c;
        }

        public static Operation getOperation(String s)
        {
            for (Operation operator : Operation.values())
            {
                if (operator.toString().equals(s)) return operator;
            }
            return null;
        }

        abstract int operate(int a, int b);

        @Override
        public String toString()
        {
            return "" + character;
        }
    }

    public int evalRPN(String[] tokens)
    {
        if (tokens == null) return -1;
        Stack<Integer> numbers = new Stack<Integer>();
        for (String token : tokens)
        {
            Operation o = Operation.getOperation(token);
            if (o == null)
            {
                numbers.push(Integer.parseInt(token));
            }
            else
            {
                int b = numbers.pop();
                int a = numbers.pop();
                int c = o.operate(a, b);
                numbers.push(c);

            }
        }
        return numbers.pop();
    }
}