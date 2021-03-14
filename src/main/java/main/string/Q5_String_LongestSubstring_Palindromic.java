package main.string;

import org.junit.Assert;

public class Q5_String_LongestSubstring_Palindromic {

  /****
   *
   * Given a string s, return the longest palindromic substring in s.
   *
   * Input: s = "babad"
   * Output: "bab"
   * Note: "aba" is also a valid answer.
   *
   */
  static String result = "";
  static int max = 0;
  public static String longestPalindrome(String s) {
    if(s == null || s == "") return s;
    if(s.length() == 1) return s;
    for(int i=0;i<s.length()-1;i++){
      findPalindrome(s, i, i);
      findPalindrome(s, i, i+1);
    }
    return result;
  }

  public static void findPalindrome(String s, int start, int end){
    while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
      start--;
      end++;
    }
    if(end-start-1 > max) {
      max = Math.max(max, end-start-1);
      result = s.substring(start+1, end);
    }

  }

  public static void main(String[] args){
    Assert.assertEquals("bab", Q5_String_LongestSubstring_Palindromic.longestPalindrome("babcd"));
  }

}
