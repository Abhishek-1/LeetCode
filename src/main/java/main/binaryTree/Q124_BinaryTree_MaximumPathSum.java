package main.binaryTree;

import main.TreeNode;

/**
 *  Problem - 124
 *
 *  A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 * The path sum of a path is the sum of the node's values in the path.
 * Given the root of a binary tree, return the maximum path sum of any path.
 *
 * Input: root = [1,2,3]
 * Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
 *
 */
public class Q124_BinaryTree_MaximumPathSum {

  /** Using Recursion **/
  int max = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    if(root == null) return 0;
    dfs(root);
    return max;
  }

  public int dfs(TreeNode root){
    if(root == null) return 0;
    int left = Math.max(dfs(root.left), 0);
    int right = Math.max(dfs(root.right), 0);
    max = Math.max(max, root.val+left+right);
    return root.val + Math.max(left, right);
  }

}
