package leetcode.Trees;

import org.junit.Assert;

/**
 * @author shivanidwivedi on 24/08/20
 * @project JavaProgramming
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Example:
 *
 * You may serialize the following tree:
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * as "[1,2,3,null,null,4,5]"
 */
public class SerializeDeserializeBinaryTree {
    int index;
    TreeNode root;

    public String serialize(TreeNode root) {
        if(root == null) {
            return "#";
        }
        StringBuilder str = new StringBuilder(String.valueOf(root.val));
        str.append(",");
        str.append(serialize(root.left));
        str.append(",");
        str.append(serialize(root.right));
        return str.toString();
    }

    public TreeNode deserialize(String data) {
        String[] s = data.split(",");
        index = 0;
        return helper(s);
    }

    private TreeNode helper(String[] s){
        if(index >= s.length){
            return null;
        }
        String data = s[index++];
        if(data.equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(data));
        root.left = helper(s);
        root.right = helper(s);
        return root;
    }

    public static void main(String[] args) {
        SerializeDeserializeBinaryTree tree = new SerializeDeserializeBinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        String s = "1,2,4,#,#,5,#,#,3,#,#";
        Assert.assertEquals(s, tree.serialize(tree.root));
        //Assert.assertEquals(tree.deserialize(tree.serialize(root)));
    }
}
