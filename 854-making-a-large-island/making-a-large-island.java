class Solution {
    int n;

    public int largestIsland(int[][] grid) {
        n = grid.length;
        int[] size = new int[n * n + 2];
        int id = 2;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int s = dfs(grid, i, j, id);
                    size[id] = s;
                    ans = Math.max(ans, s);
                    id++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int current = 1;
                    int[] neighbors = new int[4];
                    int count = 0;

                    if (i > 0 && grid[i - 1][j] > 1)
                        neighbors[count++] = grid[i - 1][j];

                    if (i < n - 1 && grid[i + 1][j] > 1)
                        neighbors[count++] = grid[i + 1][j];

                    if (j > 0 && grid[i][j - 1] > 1)
                        neighbors[count++] = grid[i][j - 1];

                    if (j < n - 1 && grid[i][j + 1] > 1)
                        neighbors[count++] = grid[i][j + 1];

                    for (int k = 0; k < count; k++) {
                        boolean duplicate = false;

                        for (int p = 0; p < k; p++) {
                            if (neighbors[p] == neighbors[k]) {
                                duplicate = true;
                                break;
                            }
                        }

                        if (!duplicate)
                            current += size[neighbors[k]];
                    }

                    ans = Math.max(ans, current);
                }
            }
        }

        return ans;
    }

    private int dfs(int[][] grid, int r, int c, int id) {
        if (r < 0 || r >= n || c < 0 || c >= n || grid[r][c] != 1)
            return 0;

        grid[r][c] = id;

        return 1
            + dfs(grid, r - 1, c, id)
            + dfs(grid, r + 1, c, id)
            + dfs(grid, r, c - 1, id)
            + dfs(grid, r, c + 1, id);
    }
}