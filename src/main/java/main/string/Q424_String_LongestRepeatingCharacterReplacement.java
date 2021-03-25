package main.string;

import org.junit.Assert;

/**
 * Given a string s that consists of only uppercase English letters, you can perform at most k operations on that string.
 *
 * In one operation, you can choose any character of the string and change it to any other uppercase English character.
 *
 * Find the length of the longest sub-string containing all repeating letters you can get after performing the above operations.
 *
 * Input:
 * s = "ABAB", k = 2
 *
 * Output:
 * 4
 *
 * Explanation:
 * Replace the two 'A's with two 'B's or vice versa.
 */

public class Q424_String_LongestRepeatingCharacterReplacement {

  public static int characterReplacement(String s, int k) {
    int start = 0;
    int[] alphabet = new int[26];
    int maxCount = 0;
    int max = 0;
    for (int i = 0; i < s.length(); i++) {
      maxCount = Math.max(++alphabet[s.charAt(i) - 'A'], maxCount);

      while (i - start + 1 - maxCount > k) {
        alphabet[s.charAt(start) - 'A']--;
        start++;
      }

      max = Math.max(max, i - start + 1);
    }

    return max;
  }

  public static void main(String[] args){
    Assert.assertEquals(4, characterReplacement("AABCD", 2));
  }

}
