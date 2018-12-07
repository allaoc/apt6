 import java.util.Map;
 import java.util.HashMap;
 import java.util.List;
 import java.util.ArrayList;
 import java.util.Collections;
 public class SpreadingNews {
	 Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
     public int minTime(int[] supervisors) {
	   for (int c = 0; c < supervisors.length; c++) {
		   map.putIfAbsent(c, new ArrayList<Integer>());
		   map.putIfAbsent(supervisors[c],new ArrayList<Integer>());
		   map.get(supervisors[c]).add(c);
	   }
	   return minForSupervisor(0);
     }
	 private int minForSupervisor(int supervisor) {
		 if (map.get(supervisor).size() == 0) return 0;
		 List<Integer> subTimes = new ArrayList<Integer>();
		 for (int sub : map.get(supervisor)) subTimes.add(minForSupervisor(sub));
		 Collections.sort(subTimes, Collections.reverseOrder());
		 for (int c = 0; c < subTimes.size(); c++) subTimes.set(c, subTimes.get(c)+c+1);
		 Collections.sort(subTimes, Collections.reverseOrder());
		 return subTimes.get(0);
	 }
   }