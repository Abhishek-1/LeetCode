package main.array;

import java.util.HashSet;
import java.util.Set;

/**
 *  Problem  - 128
 *
 *  Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 *  Input: nums = [100,4,200,1,3,2]
 *   Output: 4
 *  Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */

public class Q128_Array_LongestConsecutiveSequence {

  /** Using HashSet **/
  public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    int max = 0;
    for(int n: nums){
      set.add(n);
    }
    for(int i=0; i< nums.length; i++){
      int temp = nums[i];
      int count = 1;
      if(set.contains(temp+1)) continue;
      while(set.contains(--temp)){
        count++;
      }
      max = Math.max(count, max);
    }
    return max;
  }

}
