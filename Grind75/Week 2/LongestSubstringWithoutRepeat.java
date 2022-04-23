/**
 * Star : Useful beginner window problem
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int i = 0, j = 1;
        if(s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> seen = new HashMap<>();
        seen.put(s.charAt(0), 1); 
        for (; j < s.length(); j++) {
             char c = s.charAt(j);
            if (seen.containsKey(c)){
                max = Math.max(max, j - i); // save the current length of the window if its > max
                
                // shrink left side of window
                while (i < j && seen.containsKey(c)){
                    seen.remove(s.charAt(i));
                    i++;
                }
            }
            seen.put(c, 1);
        }
           
                       
        return Math.max(max, j - i);
            
    }
                       }
