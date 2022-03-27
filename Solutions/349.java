import java.util.HashSet;

/* Initial Solution
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> intersect = new HashSet<Integer>();
        int i = 0, j = 0;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                intersect.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i] < nums2[j]) {
                i++;
            } else if(nums1[i] > nums2[j]) {
                j++;
            } 
        }
        return intersect.stream().mapToInt(Integer::intValue).toArray();

    }
}
*/


class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
      HashSet<Integer> set1 = new HashSet<Integer>();
      for (Integer n : nums1) set1.add(n);
      HashSet<Integer> set2 = new HashSet<Integer>();
      for (Integer n : nums2) set2.add(n);
  
      set1.retainAll(set2);
  
      int [] output = new int[set1.size()];
      int idx = 0;
      for (int s : set1) output[idx++] = s;
      return output;
    }
  }
