import java.util.Comparator;
import java.util.Arrays;
public class TheBestName {
      public String[] sort(String[] names) {
             Arrays.sort(names, new MyCompare());
			 return names;
      }
	  private class MyCompare implements Comparator<String> {
		  @Override
		  public int compare (String a, String b) {
			  if (a.equals("JOHN")) return -1;
			  if (b.equals("JOHN")) return 1;
			  int aweight = 0;
			  int bweight = 0;
			  for (int c = 0; c < a.length(); c++) {
				  aweight += (int) (a.charAt(c) - 'A' + 1);
			  }
			  for (int c = 0; c < b.length(); c++) {
				  bweight += (int) (b.charAt(c) - 'A' + 1);
			  }
			  if (aweight == bweight) {
				  int comp = 0;
				  int c = 0;
				  while (comp == 0 && c < Math.min(a.length(),b.length())) {
					  comp = (int) (a.charAt(c)-b.charAt(c));
					  c++;
				  }
				  return comp;
			  }
			  return bweight-aweight;
		  }
	  }
   }