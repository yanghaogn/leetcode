public class Solution {
    public int largestRectangleArea(int[] height) {
        if(height==null||height.length==0)
        {
            return 0;
        }
        int result=0; 
        int N=height.length;
        int[] left=new int[N];
        int[] right=new int[N];
        int index;
        left[0]=0;
        for(index=1;index<N;index++)
        {
            if(height[index]<=height[index-1])
            {
                int j=left[index-1]-1;
                for(;j>=0&&height[j]>=height[index];j--)
                {
                }
                left[index]=j+1;
            }
            else
            {
                left[index]=index;
            }
        }
        right[N-1]=N-1;
        result=(right[N-1]-left[N-1]+1)*height[N-1];
        for(index=N-2;index>=0;index--)
        {
            if(height[index]<=height[index+1])
            {
                int j=right[index+1]+1;
                for(;j<N&&height[j]>=height[index];j++)
                {
                }
                right[index]=j-1;
            }
            else
            {
                right[index]=index;
            }
            result=Math.max((right[index]-left[index]+1)*height[index],result);
        }
        
        return result;
    }
}