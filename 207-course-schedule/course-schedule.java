class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph
        for (int[] p : prerequisites) {
            int course = p[0];
            int prerequisite = p[1];

            graph.get(prerequisite).add(course);
        }

        // 0 = unvisited
        // 1 = visiting
        // 2 = completely visited
        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (hasCycle(i, graph, visited)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean hasCycle(
        int course,
        List<List<Integer>> graph,
        int[] visited
    ) {

        // We reached a node that is currently in our DFS path
        if (visited[course] == 1) {
            return true;
        }

        // Already completely checked
        if (visited[course] == 2) {
            return false;
        }

        // Mark as currently visiting
        visited[course] = 1;

        for (int next : graph.get(course)) {
            if (hasCycle(next, graph, visited)) {
                return true;
            }
        }

        // Finished processing this course
        visited[course] = 2;

        return false;
    }
}
