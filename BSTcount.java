import java.util.Map;
import java.util.HashMap;
public class BSTcount {
	Map<Integer,Long> map = new HashMap<Integer,Long>();
      public long howMany(int[] values) {
            int len = values.length;
			return helper(len);
      }
	  private long helper(int len) {
		  if (len == 0 || len == 1) return 1;
		  if (map.containsKey(len)) return map.get(len);
		  long sum = 0;
		  for (int c = 0; c <= (len-1); c++) {
			  sum += (helper(c) * helper((len-1)-c));
		  }
		  map.put(len,sum);
		  return sum;
	  }
   }