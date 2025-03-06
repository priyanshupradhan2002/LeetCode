class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) 
    {
        int n=grid.length;
        int[] res=new int[2];
        HashSet<Integer> set=new HashSet<>();

        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(!set.contains(grid[i][j]))
                {
                    set.add(grid[i][j]);
                }
                else
                {
                    res[0]=grid[i][j];
                }
            }
        }

        for(int i=1;i<=n*n;i++)
        {
            if(!set.contains(i))
            {
                res[1]=i;
            }
        }
        return res;
    }
}