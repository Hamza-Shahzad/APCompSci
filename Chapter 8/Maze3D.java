//****************************************************************************************
//
// @author: Hamza Shahzad ||| Maze3D.java
// A 3D maze that the computer solves
//
//****************************************************************************************

public class Maze3D{
  
  private final int TRIED = 3;
  private final int PATH = 7;
  private int[][][] grid = 
  {
    {
      {1, 1, 0},
      {0, 1, 0},
      {0, 0, 0}
    },
    {
      {0, 0, 0},
      {1, 1, 0},
      {1, 1, 0}
    },
    {
      {1, 1, 1},
      {1, 0, 1},
      {0, 0, 1}
    }
  };
  
  public boolean traverse (int height, int row, int column)
  {
    boolean done = false;
    
    if (valid (height, row, column))
    {
      grid[height][row][column] = TRIED;  // this cell has been tried
      
      if (height == grid.length-1 && row == grid[0].length-1 && column == grid[0][0].length-1)
        done = true;  // the maze is solved
      else
      {
        done = traverse (height, row+1, column);     // down(more like out)
        if (!done)
          done = traverse (height, row, column+1);  // right
        if (!done)
          done = traverse (height, row-1, column);  // up(more like in)
        if (!done)
          done = traverse (height, row, column-1);  // left
        if (!done)
          done = traverse (height+1, row, column); //up
        if (!done)
          done = traverse (height-1, row, column); //down
      }
      
      if (done)  // this location is part of the final path
        grid[height][row][column] = PATH;

    }
    
    return done;
  }
  
  private boolean valid (int height, int row, int column)
  {
    boolean result = false;
    
    // check if cell is in the bounds of the matrix
    if (height >= 0 && height < grid.length && 
        row >= 0 && row < grid[height].length &&
        column >= 0 && column < grid[height][row].length)
      
      //  check if cell is not blocked and not previously tried
      if (grid[height][row][column] == 1)
      result = true;
    
    return result;
  }
  
  
  public String toString(){
    String result = "";
    
    for(int height = 0; height < grid.length; height++){
      for( int row = 0; row < grid[height].length; row++){
        for(int col = 0; col < grid[height][row].length; col++){
        
          
          result += grid[height][row][col] + "";
          
        }
        result += "\n";
      }
      result += "-------\n";
    }
    return result;
  }

    
}
        
        
        
    