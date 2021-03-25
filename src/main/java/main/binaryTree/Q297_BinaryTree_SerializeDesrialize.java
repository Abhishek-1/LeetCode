package main.binaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.stream.Collectors;
import main.TreeNode;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization
 * algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original
 * tree structure.
 *
 * Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format,
 * so please be creative and come up with different approaches yourself.
 *
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
 */

public class Q297_BinaryTree_SerializeDesrialize {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {

    StringBuilder sbr = new StringBuilder();
    Stack<TreeNode> stack = new Stack<>();
    while(!stack.isEmpty() || root != null){
      while(root != null){
        stack.push(root);
        sbr.append(root.val + " ");
        root = root.left;
      }
      sbr.append("NULL"+ " ");
      root = stack.pop();
      root = root.right;
    }

    return sbr.toString();

  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if(data == "" || data.length() == 0) return null;
    String[] inpArr = data.split(" ");
    if(inpArr.length == 0) return null;
    LinkedList<String> list = Arrays.stream(inpArr)
        .collect(Collectors.toCollection(LinkedList::new));
    return helper(list);

  }

  public TreeNode helper(LinkedList<String> inp){
    if(inp.isEmpty()) return null;
    String temp = inp.poll();
    if(temp.equals("NULL")) return null;
    TreeNode root = new TreeNode(Integer.parseInt(temp));
    root.left = helper(inp);
    root.right = helper(inp);
    return root;
  }

}
