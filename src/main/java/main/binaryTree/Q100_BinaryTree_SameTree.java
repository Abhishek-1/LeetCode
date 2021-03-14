package main.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import main.TreeNode;

/**
 *  Problem - 100
 *
 *  Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 */
public class Q100_BinaryTree_SameTree {

  /** Using Recursion **/
  public boolean isSameTree(TreeNode p, TreeNode q) {

    if(p == null && q == null) return true;
    if((p == null && q != null) || (p != null && q==null)) return false;
    return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

  }

  /** Using Queue and Stack **/
  public boolean isSameTree_UsingStack(TreeNode p, TreeNode q) {

    Queue<TreeNode> queue = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode max = new TreeNode(Integer.MAX_VALUE);
    while(!stack.isEmpty() || p != null){
      if(p != null){
        stack.push(p);
        queue.offer(p);
        p = p.left;
      } else {
        queue.offer(max);
        p = stack.pop();
        p = p.right;
      }
    }

    while(!stack.isEmpty() || q != null){
      if(queue.isEmpty()) return false;
      if(q != null){
        stack.push(q);
        TreeNode temp = queue.remove();
        if(temp.val != q.val) return false;
        q = q.left;
      } else {
        TreeNode temp = queue.remove();
        if(temp.val != Integer.MAX_VALUE) return false;
        q = stack.pop();
        q = q.right;
      }
    }

    return queue.isEmpty();
  }

}
