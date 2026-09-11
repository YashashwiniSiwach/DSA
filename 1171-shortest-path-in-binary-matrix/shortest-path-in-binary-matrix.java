class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        int[][] ans = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(ans[i], Integer.MAX_VALUE);
        }

        Queue<int[]> q = new LinkedList<>();

        ans[0][0] = 1;
        q.offer(new int[]{0, 0});

        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
        };

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nc >= 0 && nr < n && nc < n
                        && grid[nr][nc] == 0) {

                    if (ans[nr][nc] > ans[r][c] + 1) {
                        ans[nr][nc] = ans[r][c] + 1;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        if (ans[n - 1][n - 1] == Integer.MAX_VALUE) {
            return -1;
        }

        return ans[n - 1][n - 1];
    }
}
