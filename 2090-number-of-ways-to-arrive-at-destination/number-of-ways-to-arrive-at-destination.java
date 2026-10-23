class Solution {
    public int countPaths(int n, int[][] roads) {
         final int MOD = 1_000_000_007;

        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int time = road[2];

            adj.get(u).add(new int[]{v, time});
            adj.get(v).add(new int[]{u, time});
        }

        long[] dist = new long[n];
        int[] ways = new int[n];

        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();

            long time = curr[0];
            int node = (int) curr[1];

            if (time > dist[node]) {
                continue;
            }

            for (int[] edge : adj.get(node)) {
                int next = edge[0];
                int weight = edge[1];

                long newTime = time + weight;

                if (newTime < dist[next]) {
                    dist[next] = newTime;
                    ways[next] = ways[node];

                    pq.offer(new long[]{newTime, next});
                } else if (newTime == dist[next]) {
                    ways[next] = (int) (
                        (ways[next] + (long) ways[node]) % MOD
                    );
                }
            }
        }

        return ways[n - 1];
    }
}