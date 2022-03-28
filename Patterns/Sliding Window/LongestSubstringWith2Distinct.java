public class LongestSubstringWith2Distinct {
    
}


class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        int maxLength = 0;
        int i = 0, j = 1;
        map.put(s.charAt(i), 1); // start by putting the first char in
        for(; j < s.length(); j++) {
            if(!map.containsKey(s.charAt(j))) { // if the letter at j is one that we have not seen yet
                if(map.size() == 2) { // we already have 2 distinct characters
                    maxLength = Math.max(maxLength, j - i); //
                    while(i < j && map.size() > 1) { 
                        map.put(s.charAt(i), map.get(s.charAt(i)) - 1); // reduce the count of i by 1 
                        if(map.get(s.charAt(i)) == 0) {
                            map.remove(s.charAt(i)); // remove this mapping
                        }
                        i++; // increment i
                    }                    
                }
                map.put(s.charAt(j), 1); // put this new mapping in 

                
            } else {
                map.put(s.charAt(j), map.get(s.charAt(j)) + 1); // increment the count of s.charAt(j) in the map 
            }
        }
        maxLength = Math.max(maxLength, j - i);
        return maxLength;
    }
}

// general sliding window approach:
/**
    Two pointers, left and right, with a map that tracks which distinct elements we're counting and how much we've seen of each. 
    iterating through the string, we check if we have already seen the value at s[right]. 
        if we have already seen this, then we simply increase it's count in the map by 1. 
        if we have not seen this, then we check if the map size is already 2 (we already have 2 distinct characters) if we do:
            first check that this length, (right - left) is the maximum. if it is, store it. 
            while left < right and the map still have 2 distinct characters:
                decrement the count of s[left] in the mapping by 1. If this value becomes 0, remove the mapping.
                increment left by 1 on each iteration, moving the left part of the sliding window up. 
            then, we put the new mapping in, starting at a count of 1 for s[right].
    at the end of the iteration, we check once more if the maximum length needs to be updated (right - left). If (right - left) is bigger, update accordingly. 
*/
