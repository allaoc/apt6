public class RatRoute {
       public int numRoutes(String[] enc) {
		   char[][] grid = new char[enc.length][enc[0].length()];
		   int ratX = 0;
		   int ratY = 0;
		   int cheeseX = 0;
		   int cheeseY = 0;
           for (int k = 0; k < enc.length; k++) {
			   for (int c = 0; c < enc[k].length(); c++) {
				   grid[k][c] = enc[k].charAt(c);
				   if (grid[k][c] == 'R') {
						ratX = c;
						ratY = k;
				   }
				   if (grid[k][c] == 'C') {
					   cheeseX = c;
					   cheeseY = k;
				   }
			   }
		   }
		   return count(grid, ratX, ratY, cheeseX, cheeseY);
       }
	   private int count(char[][] grid, int ratX, int ratY, int cheeseX, int cheeseY) {
		   if (grid[ratY][ratX] == 'X') return 0;
		   if (grid[ratY][ratX] == 'C') return 1;
		   int horizontal = 0;
		   int vertical = 0;
		   if (cheeseX > ratX) horizontal = count(grid, ratX+1, ratY, cheeseX, cheeseY);
		   else if (cheeseX < ratX) horizontal = count(grid, ratX-1, ratY, cheeseX, cheeseY);
		   if (cheeseY > ratY) vertical = count(grid, ratX, ratY+1, cheeseX, cheeseY);
		   else if (cheeseY < ratY) vertical = count(grid, ratX, ratY-1, cheeseX, cheeseY);
		   return horizontal + vertical;
	   }
    }