public class AtMostKDistinctCharacters {
    
}

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k == 0) {
            return 0; // if we can have at max 0 characters, then the longest substring will be 0 chars long lmao
        }
        
        
        // to keep track of how many of a certain type of character we've seen / are counting
        HashMap<Character, Integer> map = new HashMap<>();
        // start by putting the first char of the string in
        map.put(s.charAt(0), 1); 
        int i = 0, j = 1;
        int max = 0;
        
        for(; j < s.length(); j++) {
            // two cases. We either have seen the char at j or we have not.
            if(!map.containsKey(s.charAt(j))) {
                // we currently have k chars in the string
                if(map.size() == k) {
                    // save the current maxLength (if it is max)
                    max = Math.max(max, j - i); 
                    while (i < j && map.size() == k) {
                        // delete chars from the left of the sliding window until either i > j or we have enough space in the map for a new char
                        map.put(s.charAt(i), map.get(s.charAt(i)) - 1); // decrement count
                        if (map.get(s.charAt(i)) == 0) {
                            map.remove(s.charAt(i));
                        } // if the count is 0, remove its respective mapping.
                        i++;
                    }
                }
                map.put(s.charAt(j), 1); // put the new character in 
            } else {
                // we have seen this char already, so
                map.put(s.charAt(j), map.get(s.charAt(j)) + 1); // increment its respective count
            }
            
        }
        // check at the end if our current substr is longer
        max = Math.max(max, j - i);
        return max;
        
    }
}
