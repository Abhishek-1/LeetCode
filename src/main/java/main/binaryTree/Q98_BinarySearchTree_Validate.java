package main.binaryTree;

import main.TreeNode;

/**
 *  Problem - 98
 *
 *  Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Input: root = [2,1,3]
 * Output: true
 */
public class Q98_BinarySearchTree_Validate {

  public boolean isValidBST(TreeNode root) {

    if(root == null) return true;

    return checkValidity(root, null, null);

  }

  public boolean checkValidity(TreeNode root, TreeNode lowerbound, TreeNode upperbound){

    if(root == null) return true;

    if(lowerbound != null && lowerbound.val >= root.val) return false;

    if(upperbound != null && upperbound.val <= root.val) return false;


    return checkValidity(root.left, lowerbound, root) && checkValidity(root.right, root, upperbound);

  }

  }
