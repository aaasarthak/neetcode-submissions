class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            
            adj.get(node1).add(node2);
            adj.get(node2).add(node1);
        }

        boolean[] visited = new boolean[n];
        int totalConnectedNodes = 0;
        for(int i=0; i<n; i++) {
            if(visited[i] != true) {
                dfs(adj, i, visited);
                totalConnectedNodes++;
            }
        }

        return totalConnectedNodes;
    }

    private void dfs(List<List<Integer>> adj, int node, boolean[] visited) {
        if(!visited[node]) {
            visited[node] = true;

            for(int neighbor: adj.get(node)) {
                dfs(adj, neighbor, visited);
            }
        }
    }
}
