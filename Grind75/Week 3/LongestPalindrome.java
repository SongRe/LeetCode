package Grind75.Week 3;

public class LongestPalindrome {
    
}

// idea is to check if the amount of chars of a type we've seen is two. if it reaches two, reset it
// to 0, and then add 2 to the maxLength. (since we can just put those two chars as we please to form the palindrome)
// finally, if at the end there's a char that we've only seen once (remaining), then just increase maxLength by 1.
// this is because it doesn't matter which char we choose, so long as there is one leftover. 
class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> seen = new HashMap<>();
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            seen.put(s.charAt(i), seen.getOrDefault(s.charAt(i), 0) + 1);
            if (seen.get(s.charAt(i)) % 2 == 0) { // if at any point this value becomes an even number, 
                maxLength += 2;
                seen.put(s.charAt(i), 0); //set it back to 0
            }
        }
        
        if (seen.containsValue(1)) {
            return maxLength + 1;
        }
        return maxLength;
       
    }
}