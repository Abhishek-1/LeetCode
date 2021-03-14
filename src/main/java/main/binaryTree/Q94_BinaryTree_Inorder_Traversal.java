package main.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import main.TreeNode;

/**
 *  Problem - 94
 *
 *  Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 *  Input: root = [1,null,2,3]
 *  Output: [1,3,2]
 */
public class Q94_BinaryTree_Inorder_Traversal {

  /** Using recursion **/

  List<Integer> result = new ArrayList<>();
  public List<Integer> inorderTraversal(TreeNode root) {
    if(root == null) return result;
    inorderTraversal(root.left);
    result.add(root.val);
    inorderTraversal(root.right);
    return result;
  }

  /** Using DFS, and Stack **/
  public List<Integer> inorderTraversal_DFS(TreeNode root) {

    List<Integer> output = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    while(!stack.isEmpty() || root != null){
      while(root != null){
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      output.add(root.val);
      root = root.right;
    }
    return output;
  }


}
