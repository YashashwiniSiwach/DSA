class Solution {

    int timer = 0;
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int[] disc = new int[n];
        int[] low = new int[n];

        Arrays.fill(disc, -1);

        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) {
                dfs(i, -1, graph, disc, low);
            }
        }

        return ans;
    }

    private void dfs(int node, int parent, List<List<Integer>> graph, int[] disc, int[] low) {

        disc[node] = low[node] = timer++;

        for (int neigh : graph.get(node)) {

            if (neigh == parent)
                continue;

            if (disc[neigh] == -1) {

                dfs(neigh, node, graph, disc, low);

                low[node] = Math.min(low[node], low[neigh]);

                if (low[neigh] > disc[node]) {
                    ans.add(Arrays.asList(node, neigh));
                }

            } else {

                low[node] = Math.min(low[node], disc[neigh]);
            }
        }
    }
}
