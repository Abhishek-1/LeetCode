package main.string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import org.junit.Assert;

/**
 * Problem - 3

 Given a string s, find the length of the longest substring without repeating characters.

 Input: s = "abcabcbb"
 Output: 3
 Explanation: The answer is "abc", with the length of 3.

 */

public class Q3_String_LongestSubstring_WithoutRepeatingCharacters {

  /**** Using Queue ****/
  public static int lengthOfLongestSubstringQueue(String s) {
    var start = 0;
    int max = 0;
    Queue<Character> queue = new LinkedList<>();
    if(s.length() == 0 || s.length() == 1) return s.length();
    for(int i=0; i<s.length(); i++){
      while(queue.contains(s.charAt(i)) && queue.size() > 0){
        queue.poll();
        start ++;
      }
      queue.offer(s.charAt(i));
      max = Math.max(max, i-start+1);
    }
    return max;
  }
  /**** Using Set ****/
  public static int lengthOfLongestSubstringSet(String s) {
    var start = 0;
    int max = 0;
    Set<Character> uniqueset = new HashSet<>();
    if(s.length() == 0 || s.length() == 1) return s.length();
    for(int i=0; i<s.length(); i++){
      if(!uniqueset.contains(s.charAt(i))){
        uniqueset.add(s.charAt(i));
      } else {
        while(uniqueset.contains(s.charAt(i))){
          uniqueset.remove(s.charAt(start++));
        }
        uniqueset.add(s.charAt(i));
      }

      max = Math.max(max, i-start+1);
    }
    return max;
  }

  public static void main(String args[]){
    int output1 = Q3_String_LongestSubstring_WithoutRepeatingCharacters.lengthOfLongestSubstringQueue("abcabcbb");
    Assert.assertEquals(output1, 3);
    int output2 = Q3_String_LongestSubstring_WithoutRepeatingCharacters.lengthOfLongestSubstringSet("abcabcbb");
    Assert.assertEquals(output2, 3);
  }

}
