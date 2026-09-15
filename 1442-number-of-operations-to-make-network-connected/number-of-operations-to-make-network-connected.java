class Solution {
    public int makeConnected(int n, int[][] connections) {

        if (connections.length < n - 1) {
            return -1;
        }

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int components = n;

        for (int[] connection : connections) {
            int rootA = find(connection[0], parent);
            int rootB = find(connection[1], parent);

            if (rootA != rootB) {
                parent[rootA] = rootB;
                components--; 
            }
        }

        return components - 1;
    }

    private int find(int i, int[] parent) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i], parent);
    }
}