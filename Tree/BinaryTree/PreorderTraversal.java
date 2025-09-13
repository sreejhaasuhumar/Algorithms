package Tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/*  
 * Preorder Traversal of a Binary Tree
 * Definition: In a preorder traversal, the nodes are recursively visited in this order: root, left subtree, right subtree.
 * Example: Given a binary tree [1,null,2,3], the preorder traversal is [1,2,3].
 * LeetCode Link: https://leetcode.com/problems/binary-tree-preorder-traversal/
 */

public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return innerMethod(root, list);
    }

    public static List<Integer> innerMethod(TreeNode root, List<Integer> list) {
        if(root==null)
        return list;
        list.add(root.val);
        if(root.left!=null) {
            innerMethod(root.left,list);
        }
        if(root.right!=null) {
            innerMethod(root.right,list);
        }
        return list;
    }
    
}
