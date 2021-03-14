package main.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import main.TreeNode;

/**
 *  Problem - 145
 *  Given the root of a binary tree, return the postorder traversal of its nodes' values.
 *
 *  Input: root = [1,null,2,3]
 * Output: [3,2,1]
 */
public class Q145_BinaryTree_PostOrder_Traversal {

  /** Using Recursion **/
  List<Integer> result = new ArrayList<>();

  public List<Integer> postorderTraversal(TreeNode root) {
    if(root == null) return result;
    postorderTraversal(root.left);
    postorderTraversal(root.right);
    result.add(root.val);
    return result;
  }

  /** Using BFS and Stack approach with 2 stacks**/
  public List<Integer> postorderTraversal_BFS(TreeNode root) {

    Stack<TreeNode> stack = new Stack<>();
    Stack<Integer> resultStack = new Stack<>();
    List<Integer> result = new ArrayList<>();
    if(root == null) return result;
    stack.push(root);
    while(!stack.isEmpty()){
      TreeNode temp = stack.pop();
      resultStack.push(temp.val);
      if(temp.left != null) stack.push(temp.left);
      if(temp.right != null) stack.push(temp.right);
    }
    while(!resultStack.isEmpty()){
      result.add(resultStack.pop());
    }
    return result;

  }

}
