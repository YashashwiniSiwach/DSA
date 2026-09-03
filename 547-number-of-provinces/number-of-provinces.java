class Solution {
    public int findCircleNum(int[][] isConnected) {
        int ans=0;
        int n=isConnected.length;
        boolean [] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                ans++;
                dfs(i,isConnected,visited);
            }
        }

        return ans;
    }
    public void dfs(int city,int[][] isConnected,boolean [] visited){
        visited[city] = true;

        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[city][j] == 1 && !visited[j]) {
                dfs(j, isConnected, visited);
            }
        }
    }
}