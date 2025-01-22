class Solution {
    public int[][] highestPeak(int[][] isWater) 
    {
        int[][] dir={{-1,0},{0,1},{1,0},{0,-1}};
        int m=isWater.length;
        int n=isWater[0].length;
        Queue<int[]> queue=new LinkedList<>();
        int[][] res=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(isWater[i][j]==1)
                {
                    res[i][j]=0;
                    queue.offer(new int[]{i,j});
                }
                else
                {
                    res[i][j]=-1;
                }
            }
        }
        while(!queue.isEmpty())
        {
            int[] cell=queue.poll();
            int r=cell[0];
            int c=cell[1];
            int h=res[r][c];
            //Itearating the Direction
            for(int i=0;i<4;i++)
            {
                int nr=r+dir[i][0];
                int nc=c+dir[i][1];
                //Now checking for IndexOutOfBound
                if(nr>=0 && nr<m
                && nc>=0 && nc<n
                && res[nr][nc]==-1)
                {
                    res[nr][nc]=h+1;
                    queue.offer(new int[]{nr,nc});
                }
            }

        }
        return res;
    }
}