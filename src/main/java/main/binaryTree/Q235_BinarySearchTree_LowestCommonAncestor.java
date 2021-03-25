package main.binaryTree;

import main.TreeNode;

/**
 * Problem - 235
 *
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that
 *  has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 *  Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 *  Output: 6
 *  Explanation: The LCA of nodes 2 and 8 is 6.
 *
 */
public class Q235_BinarySearchTree_LowestCommonAncestor {


/** Iterative approach **/
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    int pVal = p.val;

    int qVal = q.val;

    while(root != null){
      if(pVal > root.val && qVal > root.val) root = root.right;
      else if(pVal< root.val && qVal < root.val) root = root.left;
      else return root;
    }

    return null;


  }

  /** Recursion **/
  public TreeNode lowestCommonAncestor_Recursion(TreeNode root, TreeNode p, TreeNode q) {

    int pVal = p.val;

    int qVal = q.val;

    if(pVal > root.val && qVal > root.val) return lowestCommonAncestor(root.right, p, q);
    else if(pVal< root.val && qVal < root.val)  return lowestCommonAncestor(root.left, p, q);
    else return root;

  }

}
