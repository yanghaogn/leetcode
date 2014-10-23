public class Solution
{
    int stringHash(String s)
    {
        int h = 0;
        for (int i = 0; i < s.length(); ++i)
        {
            h = (s.charAt(i) + 31 * h) % 997;
        }
        return h;
    }

    int exponential(int M)
    {
        int n = 1;
        for (int i = 0; i < M; ++i)
        {
            n = (31 * n) % 997;
        }
        return n;
    }

    public List<Integer> findSubstring(String S, String[] L)
    {
        List<Integer> result = new LinkedList<Integer>();
        if (S == null || L == null || S.length() < L.length * L[0].length())
        {
            return result;
        }
        int len = L[0].length();
        int N = L.length;
        int power = exponential(len - 1);

        // compute hash sum for L, and hashset for input string O(L.size() * len)
        int[] hashes = new int[S.length() - len + 1];
        hashes[0] = stringHash(S.substring(0, len));
        int hashSum = 0;
        HashSet<Integer> strSet = new HashSet<Integer>();
        for (String s : L)
        {
            int hs = stringHash(s);
            strSet.add(hs);
            hashSum += hs;
        }

        // compute hash for each position (using Rabin-Karp), O(n)
        for (int i = 1; i + len <= S.length(); ++i)
        {
            int newHash = 31 * (hashes[i - 1] + 997 - power * S.charAt(i - 1) % 997)
                          + S.charAt(i + len - 1);
            hashes[i] = newHash % 997;
        }

        // if substring S[i..i+len) is not in L, set hashes[i] to 0, O(n)
        for (int i = 0; i < hashes.length; ++i)
        {
            if (!strSet.contains(hashes[i]))
            {
                hashes[i] = 0;
            }
        }

        for (int i = 0; i + N * len <= S.length(); ++i)
        {
            int h = 0;
            for (int j = 0; j < N; ++j)
            {
                h += hashes[i + j * len];
            }
            if (h == hashSum)
            {
                result.add(i);
            }
        }
        return result;
    }
}