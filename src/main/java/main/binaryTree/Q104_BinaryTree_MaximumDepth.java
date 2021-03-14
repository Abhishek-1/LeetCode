package main.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import main.TreeNode;

/**
 * Problem - 104
 *
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 */
public class Q104_BinaryTree_MaximumDepth {

  /** Using recursion **/

  int max = 0;
  public int maxDepth(TreeNode root) {

    if(root == null) return max;
    int maxChild = 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    return Math.max(max, maxChild);
  }

  /** Iterative approach **/
  public int maxDepthIterative(TreeNode root) {

    Queue<TreeNode> queue = new LinkedList<>();
    int depth = 0;
    if(root == null) return 0;
    queue.offer(root);

    while(!queue.isEmpty()){
      depth += 1;
      int size = queue.size();
      while(size > 0){
        TreeNode temp = queue.poll();
        size--;
        if(temp.left != null) queue.offer(temp.left);
        if(temp.right != null) queue.offer(temp.right);
      }
    }

    return depth;

  }


}
