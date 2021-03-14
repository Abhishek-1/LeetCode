package main.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;

/***
 *
 * Problem 15
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array
 * which gives the sum of zero.
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 *
 */

public class Q15_Array_3Sum {

  public static List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    int n = nums.length;
    for(int i =0; i< n-2; i++){
      if(i > 0 && nums[i] == nums[i-1]) continue;
      int target = -nums[i];
      int lo = i+1;
      int hi = n-1;
      while(lo < hi){
        if(nums[lo]+nums[hi] < target) lo++;
        else if(nums[lo]+nums[hi] > target) hi--;
        else {
          result.add(new ArrayList<>(Arrays.asList(nums[i], nums[lo++], nums[hi--])));
          while(lo < hi && nums[lo] == nums[lo-1]) lo++;
          while(hi > lo && nums[hi] == nums[hi+1]) hi--;
        }
      }
    }
    return result;
  }

  public static void main(String args[]){
    List<List<Integer>> result = new ArrayList<>();
    result.add(Arrays.asList(-1,-1,2));
    result.add(Arrays.asList(-1,0,1));
    Assert.assertEquals(threeSum(new int[]{-1,-1,0,1,2,-1,-4}), result);
  }




}
