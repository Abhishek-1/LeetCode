package main.array;

import org.junit.Assert;

/**
 *
 *  Problem - 33
 *
 *  There is an integer array nums sorted in ascending order (with distinct values).
 *  Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is
 *  [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3
 *  and become [4,5,6,7,0,1,2].
 *  Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 *
 *  Input: nums = [4,5,6,7,0,1,2], target = 0
 *  Output: 4
 */

public class Q33_Array_Search_RotatedSortedArray {

  /** Splitting the array in two and running binary search on both the array **/

  public static int search(int[] nums, int target) {

    int lo = 0;
    int hi = nums.length-1;
    while(lo < hi){
      int mid = (lo+hi)/2;
      if(nums[mid] > nums[hi]) lo = mid+1;
      else hi = mid;
    }

    return Math.max(binarySearchRotated(nums, 0, lo-1, target), binarySearchRotated(nums, lo, nums.length-1, target));

  }

  public static int binarySearchRotated(int[] inp, int start, int end, int target){
    if(start <= end ){

      int mid = (start+end)/2;

      if(inp[mid] == target) return mid;

      if(target < inp[mid]) return binarySearchRotated(inp, start, mid-1, target);

      else return binarySearchRotated(inp, mid+1, end, target);
    }

    return -1;
  }

  /** Using min index to calculate Real Mid and running the binary search on the array **/

  public static int search_RealMid(int[] nums, int target) {

    return binarySearch_RealMid(nums, 0, nums.length-1, target);

  }

  public static int binarySearch_RealMid(int[] nums, int start, int end, int target){
    int lo = 0;
    int hi = end;

    while(lo < hi){
      int mid = (lo + hi)/2;
      if(nums[mid] > nums[hi]) lo = mid+1;
      else hi = mid;
    }


    int rot = lo;
    lo = 0;
    hi = end;
    int n = nums.length;

    while(lo <= hi){
      int mid = (lo + hi)/2;
      int realMid = (mid+rot)%n;
      if(nums[realMid] == target) return realMid;
      if(nums[realMid] < target) lo = mid+1;
      else hi = mid-1;
    }

    return -1;
  }


  public static void main(String[] args){
    Assert.assertEquals(search(new int[]{4,5,6,7,0,1,2}, 0), 4);
    Assert.assertEquals(search_RealMid(new int[]{4,5,6,7,0,1,2}, 0), 4);
  }

}
