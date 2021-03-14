package main.string;

import org.junit.Assert;

/**
 * Problem - 647
 *
 * Given a string, your task is to count how many palindromic substrings in this string.
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 *
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 */
public class Q647_String_PalindromicSubstringCpunt {


  static int result = 0;
  public static int countSubstrings(String s) {

    if(s == null) return 0;
    if(s.length() == 1) return 1;

    for(int i=0; i< s.length()-1; i++){
      checkPalindrome(s, i, i);
      checkPalindrome(s, i, i+1);
    }

    return result+1;
  }

  public static void checkPalindrome(String inp, int start, int end){
    while(start >= 0 && end < inp.length() && inp.charAt(start) == inp.charAt(end)){
      result += 1;
      start--;
      end++;
    }
  }

  public static void main(String args[]){
    Assert.assertEquals(5,countSubstrings("abbc"));
  }

}
