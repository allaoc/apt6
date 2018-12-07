public class FloodRelief {
	char[][] vals = new char[heights.length][heights[0].length()];
      public int minimumPumps(String[] heights){
		 for (int c = 0; c < heights.length; c++) {
			 for (int r = 0; r < heights[0].length(); r++) {
				 vals[c][r] = heights[c].charAt(r);
			 }
		 }
		 int ret = 0;
		  for (int c = 0; c < vals.length; c++) {
			  for (int r = 0; r < vals[0].length; r++) {
				  if (lowest(c,r)) {
					  ret++;
					  pump(c,r);
				  }
			  }
		  }
		 return ret;
      }
	  private boolean lowest(int c, int r) {
		  if (char[c][r] == 'a') return true;
		  if (c < 0 || c >= vals.length || r < 0 || r >= vals[0].length) return true;
		  int[] horiz = {-1,0,1,0};
		  int[] vert = {0,1,0,-1};
		  if (c == 0) horiz[0] = 0;
		  if (c == vals.length-1) horiz[2] = 0;
		  if (r == 0) vert[1] = 0;
		  if (r == vals[0].length) vert[3] = 0;
		  
  }