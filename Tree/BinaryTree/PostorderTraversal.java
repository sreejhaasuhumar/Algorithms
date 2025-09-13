package Tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/*  
 * Postorder Traversal of a Binary Tree
 * Definition: In a postorder traversal, the nodes are recursively visited in this order: left subtree, right subtree, root.
 * Example: Given a binary tree [1,null,2,3], the postorder traversal is [3,2,1].
 * LeetCode Link: https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return innerMethod(root, list);
    }

    public static List<Integer> innerMethod(TreeNode root, List<Integer> list) {
        if(root==null)
        return list;
        if(root.left!=null) {
            innerMethod(root.left,list);
        }
        if(root.right!=null) {
            innerMethod(root.right,list);
        }
        list.add(root.val);

        return list;
    }  
}
