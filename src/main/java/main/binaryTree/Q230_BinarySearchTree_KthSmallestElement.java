package main.binaryTree;

import java.util.Stack;
import main.TreeNode;

/**
 *  Problem - 230
 *  Given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest element in the tree.
 *
 *  Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 */

public class Q230_BinarySearchTree_KthSmallestElement {

  public int kthSmallest(TreeNode root, int k) {

    Stack<TreeNode> stack = new Stack<>();
    int count = 0;

    while(!stack.isEmpty() || root != null){
      while(root != null){
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      count++;
      if(count == k) return root.val;
      root = root.right;
    }

    return 0;
  }

}
