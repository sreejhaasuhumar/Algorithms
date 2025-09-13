package Tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/*
 * Inorder Traversal of a Binary Tree
 * Definition: In an inorder traversal, the nodes are recursively visited in this order: left subtree, root, right subtree.
 * Example: Given a binary tree [1,null,2,3], the inorder traversal is [1,3,2].
 * LeetCode Link: https://leetcode.com/problems/binary-tree-inorder-traversal/
 */

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return innerMethod(root, list);
    }

    private List<Integer> innerMethod(TreeNode root, List<Integer> list) {
        if (root == null)
            return list;
        if (root.left != null)
            innerMethod(root.left, list);
        list.add(root.val);
        if (root.right != null)
            innerMethod(root.right, list);
        return list;
    }

}
