package main.binaryTree;

import java.util.ArrayDeque;
import java.util.Queue;
import main.TreeNode;

/**
 *  Problem - 226
 *  Given the root of a binary tree, invert the tree, and return its root.
 *  Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 */

public class Q226_BinaryTree_InvertTree {

  /** Recursive solution **/
  public TreeNode invertTree(TreeNode root) {

    if(root == null) return null;
    TreeNode temp = new TreeNode(root.val);
    temp.left = invertTree(root.right);
    temp.right = invertTree(root.left);
    return temp;
  }

  /** Iterative solution **/
  public TreeNode invertTree_iterative(TreeNode root) {

    if(root == null) return null;
    Queue<TreeNode> queue = new ArrayDeque<>();
    TreeNode head = new TreeNode();
    TreeNode result = head;
    queue.offer(root);
    while(!queue.isEmpty()){
      TreeNode temp = queue.remove();
      TreeNode left = temp.left;
      temp.left = temp.right;
      temp.right = left;
      if(temp.left != null){
        queue.offer(temp.left);
      }

      if(temp.right != null){
        queue.offer(temp.right);
      }
    }

    return root;
  }

  /** iterative without changinf input **/
  public TreeNode invertTree_NoInputChange(TreeNode root) {

    if(root == null) return null;
    Queue<TreeNode> queue = new ArrayDeque<>();
    TreeNode head = new TreeNode(root.val, root.left, root.right);
    TreeNode result = head;
    queue.offer(head);
    while(!queue.isEmpty()){
      TreeNode temp = queue.remove();
      TreeNode left = temp.left;
      temp.left = temp.right;
      temp.right = left;
      if(temp.left != null){
        queue.offer(temp.left);
      }

      if(temp.right != null){
        queue.offer(temp.right);
      }
    }

    return result;
  }

}
