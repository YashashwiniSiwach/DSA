class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> reversedGraph = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            reversedGraph.add(new ArrayList<>());
        }

        for (int a = 0; a < n; a++) {
            for (int b : graph[a]) {
                reversedGraph.get(b).add(a);
            }
        }

        int[] indegree = new int[n];

        for (int u = 0; u < n; u++) {
            for (int v : reversedGraph.get(u)) {
                indegree[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);

            for (int i : reversedGraph.get(node)) {
                indegree[i]--;

                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }
        }

        Collections.sort(ans);
        return ans;
    }
}