package main.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;

/**
 * Problem - 242
 *
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 */

public class Q242_String_ValidAnagram {

  /** Using Hashmap **/

  public static boolean isAnagram(String s, String t) {

    Map<Character, Integer> map = new HashMap<>();

    for(int i=0; i<s.length(); i++){
      Character ch = s.charAt(i);
      if(map.containsKey(ch)){
        map.put(ch, map.get(ch) + 1);
      } else {
        map.put(ch, 1);
      }
    }
    for(int i=0; i<t.length(); i++){
      Character ch = t.charAt(i);
      if(!map.containsKey(ch)){
        return false;
      } else {
        if(map.get(ch) == 1) map.remove(ch);
        else map.put(ch, map.get(ch)-1);
      }
    }
    return map.isEmpty();
  }

  /** Sorting the character array **/
  public static boolean isAnagram_Sorting(String s, String t) {

    if(s.length() != t.length()) return false;

    char[] s1 = s.toCharArray();
    char[] s2 = t.toCharArray();

    Arrays.sort(s1);
    Arrays.sort(s2);

    return Arrays.equals(s1, s2);

  }

  /** Using hash table of 26 Entries **/
  public static boolean isAnagram_IntegerArray(String s, String t) {

    if(s.length() != t.length()) return false;

    int[] counter = new int[26];

    for(int i=0; i< s.length(); i++){
      counter[s.charAt(i) - 'a']++;
    }

    for(int i=0; i< t.length(); i++){

      counter[t.charAt(i) - 'a']++;
      if(counter[t.charAt(i) - 'a'] < 0) return false;
    }

    return true;

  }

  public static void main(String[] args){
    Assert.assertEquals(isAnagram("anagram", "nagaram"), true);
    Assert.assertEquals(isAnagram_Sorting("anagram", "nagaram"), true);
    Assert.assertEquals(isAnagram_IntegerArray("anagram", "nagaram"), true);
  }

}
