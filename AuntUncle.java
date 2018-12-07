 import java.util.ArrayList;
 import java.util.List;
 import java.util.Set;
 import java.util.HashSet;
 import java.util.Collections;
 public class AuntUncle {
       public String[] list(String[] parents, String target) {
           List<Family> list = new ArrayList<Family>();
		   Set<String> ret = new HashSet<String>();
		   Family targetFam = null;
		   String[] grandparents;
		   for (String info : parents) {
			   String[] fam = info.split(" ");
			   Family next = new Family(fam[0],fam[1],fam[2]);
			   list.add(next);
			   if (next.getChild().equals(target)) targetFam = next;
		   }
		   if (targetFam == null) return new String[0];
		   for (Family comp : list) {
			   if (targetFam.parentIsChild(comp)) {
				   grandparents = comp.getParents();
				   for (Family parcomp : list) {
					   if (comp!=parcomp && parcomp.sameParents(grandparents) && !targetFam.parentIsChild(parcomp) && targetFam!=parcomp) ret.add(parcomp.getChild());
				   }
			   }
		   }
		   List<String> toret = new ArrayList<String>(ret);
		   Collections.sort(toret);
		   return toret.toArray(new String[0]);
       }
	   private class Family {
		   String myParent1;
		   String myParent2;
		   String myChild;
		   public Family(String parent1, String parent2, String child) {
			   myParent1 = parent1;
			   myParent2 = parent2;
			   myChild = child;
		   }
		   public String getChild() {
			   return myChild;
		   }
		   public boolean parentIsChild(Family comp) {
			   if (comp.getChild().equals(myParent1) || comp.getChild().equals(myParent2)) return true;
			   return false;
		   }
		   public boolean sameParents(String[] parents) {
			   for (String parent : parents) {
				   if (parent.equals(myParent1) || parent.equals(myParent2)) return true;
			   }
				return false;
		   }
		   public String[] getParents() {
			   String[] ret = new String[2];
			   ret[0] = myParent1;
			   ret[1] = myParent2;
			   return ret;
		   }
	   }
   }