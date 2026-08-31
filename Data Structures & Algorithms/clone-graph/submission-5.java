/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        Map<Integer, Node> clonedNodeMap = new HashMap<>();

        Node clonedNode = new Node(node.val);
        clonedNodeMap.put(node.val, clonedNode);

        dfs(node, clonedNode, clonedNodeMap);
        return clonedNode;
    }
    
    private void dfs(Node node, Node clonedNode, Map<Integer, Node> clonedNodeMap) {
        for(int i=0; i<node.neighbors.size(); i++) {
            if(clonedNodeMap.get(node.neighbors.get(i).val) != null) {
                clonedNode.neighbors.add(clonedNodeMap.get(node.neighbors.get(i).val));
            } else {
                Node cloned = new Node(node.neighbors.get(i).val);
                clonedNode.neighbors.add(cloned);
                clonedNodeMap.put(node.neighbors.get(i).val, cloned);
                dfs(node.neighbors.get(i), cloned, clonedNodeMap);
            }
        }
    }
}