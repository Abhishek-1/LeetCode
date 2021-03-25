package main.bfs_dfs_backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import org.junit.Assert;

/**
 *
 * Problem - 139
 *
 * Given a string s and a dictionary of strings wordDict,
 * return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 */

public class Q139_Combination_WordBreak {

  /** Usinge DFS Backtrack approach **/

  static Set<Integer> visited = new HashSet<>();
  public static boolean wordBreak(String s, List<String> wordDict) {

    return dfsSearch(s, 0, wordDict);

  }

  public static boolean dfsSearch(String s, int start, List<String> wordDict){
    if(start == s.length()) return true;

    if(visited.contains(start)) return false;
    visited.add(start);
    for(int i=start; i<= s.length(); i++){
      if(wordDict.contains(s.substring(start, i))){
        if(dfsSearch(s, i, wordDict)) return true;
      }
    }

    return false;
  }

  /** Using BFS approach **/
  public static boolean wordBreak_DFS(String s, List<String> wordDict) {

    Queue<Integer> queue = new ArrayDeque<>();
    Set<Integer> visited = new HashSet<>();
    if(s.length() == 0) return true;

    queue.add(0);

    while(!queue.isEmpty()){
      int index = queue.remove();
      if(visited.contains(index)) continue;
      visited.add(index);
      for(int i=index+1; i<= s.length(); i++){
        if(wordDict.contains(s.substring(index,i))){
          if(i == s.length()) return true;
          queue.add(i);
        }
      }
    }

    return false;
  }

  public static void main(String[] args){
    Assert.assertEquals(wordBreak("leetcode", new ArrayList<String>(Arrays.asList("leet", "code"))), true);
    Assert.assertEquals(wordBreak_DFS("leetcode", new ArrayList<String>(Arrays.asList("leet", "code"))), true);
  }





}
