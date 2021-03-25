package main.array;

import org.junit.Assert;

/**
 *
 * Problem - 153
 *
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 *
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 *
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 *
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 */

public class Q153_Array_Min_RotatedSorted {

  public static int findMin(int[] nums) {

    int lo = 0;
    int hi = nums.length-1;
    while(lo<hi){
      int mid = (lo+hi)/2;
      if(nums[mid] > nums[hi]) lo = mid+1;
      else hi = mid;
    }

    return nums[lo];

  }

  public static void main(String[] args){
    Assert.assertEquals(findMin(new int[]{3,4,5,1,2}), 1);
  }

}
