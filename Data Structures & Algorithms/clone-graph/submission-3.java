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
    Map<Integer, Node> nodeMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null) return null;

        if(nodeMap.containsKey(node.val)) return nodeMap.get(node.val);
        var clonedNode = new Node(node.val);
        nodeMap.put(node.val, clonedNode);
        for(Node neighbor : node.neighbors) {
            clonedNode.neighbors.add(cloneGraph(neighbor));
        }

        return clonedNode;
    }
}