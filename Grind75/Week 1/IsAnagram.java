public class IsAnagram {
    
}

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        char[] sCount = s.toCharArray();
        char[] tCount = t.toCharArray();
        Arrays.sort(sCount);
        Arrays.sort(tCount);
        
        for (int i = 0; i < sCount.length; i++) {
            if(sCount[i] != tCount[i]) return false;
        }
        
        return true;
        
    }
}
