import java.util.*;

class Solution {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private void bfs(char[][] grid, int row, int col) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        grid[row][col] = '0';

        int[][] directions = {
            {-1, 0}, // up
            {1, 0},  // down
            {0, -1}, // left
            {0, 1}   // right
        };

        while (!q.isEmpty()) {

            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < m &&
                    nc >= 0 && nc < n &&
                    grid[nr][nc] == '1') {

                    grid[nr][nc] = '0';
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
