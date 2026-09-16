class Solution {

    int[] parent;
    int[] rank;

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    void union(int a, int b) {

        int pa = find(a);
        int pb = find(b);

        if (pa == pb) {
            return;
        }

        if (rank[pa] < rank[pb]) {
            parent[pa] = pb;
        }
        else if (rank[pa] > rank[pb]) {
            parent[pb] = pa;
        }
        else {
            parent[pb] = pa;
            rank[pa]++;
        }
    }

    public int removeStones(int[][] stones) {

        parent = new int[20002];
        rank = new int[20002];

        // Initially, every node is its own parent
        for (int i = 0; i < 20002; i++) {
            parent[i] = i;
        }

        // Connect row and column
        for (int[] stone : stones) {

            int row = stone[0];
            int col = stone[1] + 10001;

            union(row, col);
        }

        // Count connected components
        boolean[] visited = new boolean[20002];
        int components = 0;

        for (int[] stone : stones) {

            int row = stone[0];
            int root = find(row);

            if (!visited[root]) {
                visited[root] = true;
                components++;
            }
        }

        return stones.length - components;
    }
}