/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {
    List<Integer> nodeValues = new ArrayList<>();
    int index = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        preOrderTraversal(root);
        var serializedString = Arrays.toString(nodeValues.toArray());
        return serializedString.substring(1, serializedString.length() - 1);
    }

    private void preOrderTraversal(TreeNode root) {
        if(root == null) {
            nodeValues.add(null);
            return;
        }

        nodeValues.add(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        var list = Arrays.stream(data.substring(0, data.length()).split(", ")).toList();
        return  buildTreeWithPreOrder(list);
    }

    private TreeNode buildTreeWithPreOrder(List<String> list) {
        var root = list.get(index);
        if(root.equals("null")) {
            index++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(root));
        index++;
        node.left = buildTreeWithPreOrder(list);
        node.right = buildTreeWithPreOrder(list);
        return node;
    }
}
