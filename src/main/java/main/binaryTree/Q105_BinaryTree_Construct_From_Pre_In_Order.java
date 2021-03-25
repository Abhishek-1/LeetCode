package main.binaryTree;

import java.util.HashMap;
import main.TreeNode;

/**
 *
 *  Problem- 105
 *
 *  Given two integer arrays preorder and inorder where preorder is the preorder traversal of a
 *  binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 *
 *  Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 */

public class Q105_BinaryTree_Construct_From_Pre_In_Order {

  public TreeNode buildTree(int[] preorder, int[] inorder) {

    HashMap<Integer, Integer> rootMap = new   HashMap<>();

    for(int i=0; i< inorder.length; i++){
      rootMap.put(inorder[i], i);
    }

    return dfs(preorder, 0, 0, inorder.length-1, inorder, rootMap, "main");

  }


  public TreeNode dfs(int[] preorder, int prestart, int instart, int inend, int[] inorder, HashMap<Integer, Integer> rootMap, String val){



    if(prestart >= preorder.length || instart > inend) return null;

    TreeNode root = new TreeNode(preorder[prestart]);

    int index = rootMap.get(root.val);

    root.left = dfs(preorder, prestart + 1, instart, index-1, inorder, rootMap, "left");
    root.right = dfs(preorder, index + 1, index+1, inend, inorder, rootMap, "right");

    return root;

  }

}
