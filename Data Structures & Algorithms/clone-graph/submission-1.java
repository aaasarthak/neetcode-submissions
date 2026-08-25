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
        if(node == null) {
            return null;
        }

        if(node.neighbors.isEmpty()) {
            return new Node(node.val);
        }

        Node cloneNode = new Node(node.val);
        List<Node> visited = new ArrayList<>();

        Queue<Node[]> queue = new LinkedList<>();
        queue.add(new Node[]{node, cloneNode});
        visited.add(cloneNode);

        while(!queue.isEmpty()) {
            var nodePair = queue.poll();
            
            var originalNode = nodePair[0];
            var copyNode = nodePair[1];

            for(int i=0; i<originalNode.neighbors.size(); i++) {
                var mainNode = originalNode.neighbors.get(i);
                Node existingNewNode = visited.stream().filter(n -> n.val == mainNode.val)
                    .findFirst().orElse(new Node(mainNode.val));
                copyNode.neighbors.add(existingNewNode);

                if(visited.stream().noneMatch(node1 -> node1.val == mainNode.val)) {
                    queue.add(new Node[]{mainNode, existingNewNode});
                }
            }

            visited.add(copyNode);
        }

        return cloneNode;
    }
}