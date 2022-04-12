public class IsPalindrome {
    
}

class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        s = s.toLowerCase();
        while (i < j) {
            if (Character.isLetterOrDigit(s.charAt(i)) && Character.isLetterOrDigit(s.charAt(j))) {
                if (s.charAt(i) != s.charAt(j)) return false;
                i++;
                j--;
            } else if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;   
            } else if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
        }
        return s.charAt(i) == s.charAt(j);
    }
}
// two pointers approach
