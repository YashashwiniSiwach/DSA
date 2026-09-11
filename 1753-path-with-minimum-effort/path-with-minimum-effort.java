class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        int[][] direction = {
            {-1, 0},
            {0, -1},
            {1, 0},
            {0, 1}
        };

        dist[0][0] = 0;

        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int x = curr[0];
            int y = curr[1];
            int z = curr[2];

            if (y == n - 1 && z == m - 1) {
                return x;
            }

            for (int[] dir : direction) {
                int nr = dir[0] + y;
                int nc = dir[1] + z;

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {

                    int diff = Math.abs(
                        heights[nr][nc] - heights[y][z]
                    );

                    int newDiff = Math.max(x, diff);

                    if (newDiff < dist[nr][nc]) {
                        dist[nr][nc] = newDiff;

                        pq.offer(new int[]{
                            newDiff,
                            nr,
                            nc
                        });
                    }
                }
            }
        }

        return 0;
    }
}
