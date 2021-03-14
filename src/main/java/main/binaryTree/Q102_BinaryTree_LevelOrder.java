package main.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import main.TreeNode;

/**
 *  Problem - 15
 *
 *  Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 *
 *  Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 */
public class Q102_BinaryTree_LevelOrder {

  public List<List<Integer>> levelOrder(TreeNode root) {
    if(root == null) return new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()){
      int size = queue.size();
      List<Integer> level = new ArrayList<>();
      while(size > 0){
        TreeNode temp = queue.poll();
        size--;
        level.add(temp.val);
        if(temp.left != null) queue.offer(temp.left);
        if(temp.right != null) queue.offer(temp.right);
      }
      result.add(level);
    }
    return result;
  }

}
