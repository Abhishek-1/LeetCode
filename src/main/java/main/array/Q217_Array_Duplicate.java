package main.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 *  Problem - 217
 *  Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 *
 *  Input: nums = [1,2,3,1]
 *  Output: true
 */

public class Q217_Array_Duplicate {

  /** Using Set **/

  public boolean containsDuplicate_Set(int[] nums) {

    Set<Integer> numSet = new HashSet<>();

    for(int i=0; i< nums.length; i++){
      if(numSet.contains(nums[i])){
        return true;
      }
      numSet.add(nums[i]);
    }
    return false;

  }



  /** Using Java 8 Streams **/
  public boolean containsDuplicate(int[] nums) {

    HashSet<Integer> set = new HashSet<>();
    List<Integer> result = Arrays.stream(nums)
        .boxed()
        .filter(n -> !set.add(n))
        .collect(Collectors.toList());

    return !result.isEmpty();

  }

}
