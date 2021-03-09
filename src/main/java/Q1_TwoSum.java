import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/****
 Problem - 1

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 Input: nums = [2,7,11,15], target = 9
 Output: [0,1]
 Output: Because nums[0] + nums[1] == 9, we return [0, 1].

 ****/
public class Q1_TwoSum {
    public static int[] twoSum(int[] nums, int target) {

      Map<Integer, Integer> numMap = new HashMap<>();

      for(int i=0; i<nums.length;i++){
        if(!numMap.containsKey(nums[i])){
          numMap.put(target-nums[i], i);
        } else {
          return new int[]{numMap.get(nums[i]), i};
        }
      }

      return new int[]{};
    }

    public static void main(String[] args){
      int[] result = new int[]{0,1};
      Assert.assertArrayEquals(Q1_TwoSum.twoSum(new int[]{2,7,11,15}, 9), result);
    }
  }
