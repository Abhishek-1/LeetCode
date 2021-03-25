package main.matrix;

/**
 * Problem - 73
 *
 * Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.
 *
 * Follow up:
 *
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 *
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 */

public class Q73_Matrix_SetMatrix_Zero {

  public void setZeroes(int[][] matrix) {

    int[] row = new int[matrix.length];
    int[] col = new int[matrix[0].length];
    for (int i =0; i< matrix.length; i++){
      for(int j=0; j<matrix[0].length; j++){
        if(matrix[i][j] == 0){
          row[i] = 1;
          col[j] = 1;
        }
      }
    }

    for (int i =0; i< matrix.length; i++){
      for(int j=0; j<matrix[0].length; j++){
        if(row[i] == 1 || col[j] == 1) matrix[i][j] = 0;
      }
    }
  }

}
