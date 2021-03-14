package main.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import main.TreeNode;

/**
 *  Problem - 144
 *
 *  Given the root of a binary tree, return the preorder traversal of its nodes' values.
 *
 *  Input: root = [1,null,2,3]
 * Output: [1,2,3]
 */
public class Q144_BinaryTree_PreOrder_Traversal {

  /**  Using Recursion **/
  List<Integer> result = new ArrayList<>();

  public List<Integer> preorderTraversal(TreeNode root) {
    if(root == null) return result;
    result.add(root.val);
    preorderTraversal(root.left);
    preorderTraversal(root.right);
    return result;

  }

  /**  Using DFS and Stack **/
  public List<Integer> preorderTraversal_DFS(TreeNode root) {
    List<Integer> output = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    while(!stack.isEmpty() || root != null){
      while(root != null){
        stack.push(root);
        output.add(root.val);
        root = root.left;
      }
      root = stack.pop();
      root = root.right;
    }
    return output;
  }

}
