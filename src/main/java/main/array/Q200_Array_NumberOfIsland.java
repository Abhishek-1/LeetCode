package main.array;

import org.junit.Assert;

/**
 *  Problem - 200
 *
 *  Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *  An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid
 *  are all surrounded by water.
 */
public class Q200_Array_NumberOfIsland {

  static int maxCount = 0;
  public static int numIslands(char[][] grid) {

    for(int i=0; i<grid.length; i++){
      for(int j=0; j< grid[0].length; j++){
        if(grid[i][j] == '1'){
          maxCount += 1;
          countIsland(grid, i, j);
        }
      }
    }
    return maxCount;

  }

  public static void countIsland(char[][] grid, int row, int col){
    if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == '1'){
      grid[row][col] = 'C';
      countIsland(grid, row+1, col);
      countIsland(grid, row-1, col);
      countIsland(grid, row, col+1);
      countIsland(grid, row, col-1);
    }
  }

  public static void main(String[] args) {
    Assert.assertEquals(numIslands(
        new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}), 1);
  }
}
