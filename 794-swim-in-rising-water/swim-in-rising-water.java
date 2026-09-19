class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        boolean[][] visited = new boolean[n][n];
        pq.offer(new int[]{grid[0][0],0,0});
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while(!pq.isEmpty()){
            int [] curr=pq.poll();
            int level = curr[0];
            int r = curr[1];
            int c = curr[2];

            if(visited[r][c]){
                continue;
            }
            visited[r][c]=true;
            if(r==n-1 && c==n-1){
                return level;
            }
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];            
                if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                    continue;
                }

                if (visited[nr][nc]) {
                    continue;
                }
                int newLevel = Math.max(level, grid[nr][nc]);

                pq.offer(new int[]{newLevel, nr, nc});
            }
        }

        return -1;
    }
}
