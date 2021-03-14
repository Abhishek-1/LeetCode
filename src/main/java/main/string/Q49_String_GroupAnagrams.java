package main.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.Assert;

/**
 * Problem - 49
 *
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 **/
public class Q49_String_GroupAnagrams {


  /** Using Hash Map **/
  public static List<List<String>> groupAnagrams(String[] strs) {

    Map<String, List<String>> wordMap = new HashMap<>();
    List<List<String>> result = new ArrayList<>();
    for(String word: strs){
      char[] charArr = word.toCharArray();
      Arrays.sort(charArr);
      String key = Arrays.toString(charArr);
      List<String> val = wordMap.getOrDefault(key, new ArrayList<>());
      val.add(word);
      wordMap.put(key, val);
    }
    for(List<String> temp : wordMap.values()){
      result.add(temp);
    }
    return result;

  }

  /** Using Streams **/
  public static List<List<String>> groupAnagramsStreams(String[] strs) {
    return new ArrayList<>(Arrays.stream(strs)
    .collect(Collectors.groupingBy(str -> getKey(str), Collectors.toList())).values());
  }


  public static String getKey(String s){
    char[] c = s.toCharArray();
    Arrays.sort(c);
    return String.valueOf(c);
  }


  public static void main(String[] args){
    var result = new ArrayList<>();
    result.add(Arrays.asList("tan", "nat"));
    result.add(Arrays.asList("bat"));
    result.add(Arrays.asList("eat","tea","ate"));
    Assert.assertEquals(result, groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    var result2 = new ArrayList<>();
    result2.add(Arrays.asList("eat","tea","ate"));
    result2.add(Arrays.asList("bat"));
    result2.add(Arrays.asList("tan", "nat"));
    Assert.assertEquals(result2, groupAnagramsStreams(new String[]{"eat","tea","tan","ate","nat","bat"}));
  }

}
