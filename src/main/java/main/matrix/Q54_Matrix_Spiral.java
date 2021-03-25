package main.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 *  Problem - 54
 *
 *  Given an m x n matrix, return all elements of the matrix in spiral order.
 *  Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 *  Output: [1,2,3,6,9,8,7,4,5]
 */

public class Q54_Matrix_Spiral {

  /** Using 4 pointers **/
  public List<Integer> spiralOrder(int[][] matrix) {

    List<Integer> result = new ArrayList<>();

    int count = 0;
    int n = matrix.length*matrix[0].length;

    int x = 0;
    int y = 0;
    int left = 0;
    int right = matrix[0].length-1;
    int top = 0;
    int bottom = matrix.length-1;
    while(count < n){

      for(int i=left; i<= right; i++){
        result.add(matrix[top][i]);
        count++;
      }

      for(int i=top+1; i<= bottom; i++){
        result.add(matrix[i][right]);
        count++;
      }

      for(int i=right-1; i>= left && top != bottom; i--){
        result.add(matrix[bottom][i]);
        count++;
      }


      for(int i=bottom-1; i> top && left != right ; i--){
        result.add(matrix[i][left]);
        count++;
      }

      top++;
      left++;
      right--;
      bottom--;


    }

    return result;
  }

}
