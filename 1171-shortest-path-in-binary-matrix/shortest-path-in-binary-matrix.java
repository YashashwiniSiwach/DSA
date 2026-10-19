class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]!=-0 || grid[n-1][n-1]!=-0 ){
            return -1;
        }
        Queue<int[]>pq=new LinkedList<>();
        pq.offer(new int[]{0,0,1});
        int [][] direction={{0,1},{1,0},{1,1},{-1,-1},{-1,0},{0,-1},{-1,1},{1,-1}};
        while(!pq.isEmpty()){
            int [] curr=pq.poll();
            int row=curr[0];
            int col=curr[1];
            int len=curr[2];
            if(row==n-1 && col==n-1){
                return len;
            }
            for(int [] dir:direction){
                int newrow=row+dir[0];
                int newcol=col+dir[1];
                if(newrow >= 0 && newrow < n &&
                    newcol >= 0 && newcol < n &&
                    grid[newrow][newcol] == 0){
                        grid[newrow][newcol]=1;
                        pq.offer(new int[]{newrow,newcol,len+1});
                    }
            }
        }

        return -1;

    }
}