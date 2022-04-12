public class BackSpaceRemoveEquals {
    
}


class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int skipS = 0, skipT = 0;
        while (i >= 0 || j >= 0) {
            
            // anytime there is a char to be skipped, either the char is # or skipS > 0 (because of a previous #)
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    i--;
                    skipS--;
                } else break;
            }
            
            while (j >= 0) {
                if (t.charAt(j) == '#'){
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else break;
            }
            
            // if one reaches the end (start of the string) before the other, return false
            if ((j >= 0) != (i >= 0)) {
                return false;
            }
            
            // if the chars after skips aren't the same, then return false
            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
                return false;
            }
            
            

            i--;
            j--;
        }
        return true;
    }
}
