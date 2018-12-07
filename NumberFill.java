public class NumberFill {
      public int gradient(String[] picture) {
		  char[][] grid = new char[picture.length][picture[0].length()];
		   for (int k = 0; k < picture.length; k++) {
			   for (int c = 0; c < picture[k].length(); c++) {
				   grid[k][c] = picture[k].charAt(c);
			   }
		   }
		   return color(grid);
      }
	  private int color(char[][] grid) {
		  int ret = 0;
		  for (int y = 0; y < grid.length; y++) {
			  for (int x = 0; x < grid[0].length; x++) {
				  int[] instruction = find(grid, x, y);
				  if (instruction[0] != -1) ret += (instruction[0]+x-instruction[1]);
			  }
		  }
		  return ret;
	  }
	  private int[] find(char[][] grid, int x, int y) {
		  if (x < 0 || x >= grid[0].length || y < 0 || y >= grid.length || grid[y][x] == 'X') {
			  int[] ret = {-1,x};
			  return ret;
		  }
		  int[] here = {-1,x};
		  if (grid[y][x] != '.') here[0] = Character.getNumericValue(grid[y][x]);
		  int[] left = find(grid,x-1,y);
		  int[] right = find(grid,x+1,y);
		  int[] up = find(grid,x,y+1);
		  int[] down = find(grid,x,y-1);
		  int[] horiz = new int[2];
		  int[] vert = new int[2];
		  int[] alldir = new int[2];
		  int[] ret = new int[2];
		  if (right[0] > left[0]) horiz = right;
		  else if (right[0] == left[0] && right[1] < left[1]) horiz = right;
		  else horiz = left;
		  if (up[0] > down[0]) vert = up;
		  else if (up[0] == down[0] && up[1] < down[1]) vert = up;
		  else vert = down;
		  if (horiz[0] > vert[0]) alldir = horiz;
		  else if (horiz[0] == vert[0] && horiz[1] < vert[1]) alldir = horiz;
		  else alldir = vert;
		  if (alldir[0] > here[0]) return alldir;
		  if (alldir[1] < here[1]) return alldir;
		  return here;
	  }
   }