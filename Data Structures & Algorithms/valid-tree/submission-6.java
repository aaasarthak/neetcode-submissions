class Solution {
    List<List<Integer>> adjList = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {

        for(int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        if(dfs(0, null)) {
            return visited.size() == n;
        }

        return false;
    }

    private boolean dfs(Integer node, Integer previousNode) {
        if(visited.contains(node)) return false;
        visited.add(node);

        for(int i=0; i<adjList.get(node).size(); i++) {
            if(adjList.get(node).get(i) == previousNode) continue;

            if(!dfs(adjList.get(node).get(i), node)) {
                return false;
            }
        }

        return true;
    }
}
