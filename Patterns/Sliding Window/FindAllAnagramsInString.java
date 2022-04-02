public class FindAllAnagramsInString {
    
}

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] mapS = new int[26]; // this will count the chars we have seen
        int[] mapP = new int[26];
        ArrayList<Integer> result = new ArrayList<>();
        if(p.length() > s.length()) {
            return result;
        }
        
        
        //preload first p.length letters
        for(int i = 0; i < p.length(); i++) {
            mapS[s.charAt(i) - 'a']++;
            mapP[p.charAt(i) - 'a']++;
        }
        
        // this will be our sliding window
        // we keep the sliding window a fixed length of p
        int i = 0;
        for(; i < s.length() - p.length(); i++) {
            if(matches(mapS, mapP)) {
                result.add(i);
            }
            mapS[s.charAt(i + p.length()) - 'a']++; //expanding window at i + p.length()
            mapS[s.charAt(i) - 'a']--; // sliding window over by removing the count of whatver char is at i
        }
        if(matches(mapS, mapP)) {
            result.add(i);
        }
        return result;
        
    }
    
    public boolean matches(int[] map1, int[] map2) {
        for(int i = 0; i < map2.length; i++) {
            if(map1[i] != map2 [i]) return false;
        }
        return true;
    }
    
    public boolean isAllZero(int[] map1) {
        for(int i = 0; i < map1.length; i++) {
            if(map1[i] != 0) return false;
        }
        return true;
    }
}
