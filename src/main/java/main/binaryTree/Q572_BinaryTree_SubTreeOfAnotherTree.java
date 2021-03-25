package main.binaryTree;

import java.util.Stack;
import main.TreeNode;

/**
 * Problem - 572
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s.
 * A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
 */

public class Q572_BinaryTree_SubTreeOfAnotherTree {

  Boolean ret = false;
  public boolean isSubtree(TreeNode s, TreeNode t) {

    Stack<TreeNode> stack = new Stack<>();
    Boolean match = false;

    while(!stack.isEmpty() || s!= null){
      while(s!= null){
        if(s.val == t.val) {
          ret = checkSameSubTree(s, t);
          if(ret) return ret;
        }
        stack.push(s);
        s = s.left;
      }
      s = stack.pop();
      s = s.right;
    }

    return ret;

  }

  public boolean checkSameSubTree(TreeNode s, TreeNode t){
    if(s == null && t == null) return true;
    if((s == null && t != null) || (s != null && t==null)) return false;
    return  s.val == t.val && checkSameSubTree(s.left, t.left) && checkSameSubTree(s.right, t.right);

  }

}
