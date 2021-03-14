package main.array;

import org.junit.Assert;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are
 * drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis
 * forms a container, such that the container contains the most water.
 **/

/***----------  Try alternative solution later on ----------***/

public class Q11_Array_WaterContainer {

  public static int maxArea(int[] height) {

    var maxArea= 0;
    int start = 0;
    int end = height.length-1;
    while(start < end){
      maxArea = Math.max(maxArea, Math.min(height[start], height[end])*(end-start));
      if(height[end] > height[start])
        start++;
      else
        end--;
    }
    return maxArea;
  }

  public static void main(String args[]){
    Assert.assertEquals(17, Q11_Array_WaterContainer.maxArea(new int[]{2,3,4,5,18,17,6}));
  }

}
