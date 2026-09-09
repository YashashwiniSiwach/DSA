class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>>adj= new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] p: prerequisites){
            int courses =p[0];
            int prerequisite=p[1];

        adj.get(prerequisite).add(courses);
        }
        int [] vis=new int [numCourses];
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<numCourses;i++){
            if(vis[i]==0){
                if(!dfs(i,adj,vis,st)){
                    return false;
                }
            }
        }
        return true;

    }
    private boolean dfs(int node,
        List<List<Integer>> adj,
        int[] visited,
        Stack<Integer> stack
    ) {

        if (visited[node] == 1) {
            return false;
        }

    
        if (visited[node] == 2) {
            return true;
        }

        visited[node] = 1;

       for (int next : adj.get(node)) {

            if (!dfs(next, adj, visited, stack)) {
                return false;
            }
        }
        visited[node] = 2;
        stack.push(node);

        return true;
    }
}