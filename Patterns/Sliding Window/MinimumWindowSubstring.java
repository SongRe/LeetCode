public class MinimumWindowSubstring {
    
}
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();
        HashMap<Character, Integer> seen = new HashMap<>();
        
        for(int i = 0; i < t.length(); i++) {
            if(mapT.containsKey(t.charAt(i))) {
                mapT.put(t.charAt(i), mapT.get(t.charAt(i)) + 1);
            } else {
                mapT.put(t.charAt(i), 1); 
            }
        }
        String lowestString = "";
        String curString = "";
        
        // find the first string that has all the chars from t
        for(int i = 0; i < s.length(); i++) {
            curString += s.charAt(i);
            if(mapS.containsKey(s.charAt(i))) {
                mapS.put(s.charAt(i), mapS.get(s.charAt(i)) + 1);
            } else {
                mapS.put(s.charAt(i), 1); 
            }
            if(contains(mapS, mapT)) {
                lowestString = curString;
                break;
            }
        }
        int i = 0, j = curString.length();
        while(i < j) {
            mapS.put(s.charAt(i), mapS.get(s.charAt(i)) - 1);
            if(mapS.get(s.charAt(i)) == 0) {
                mapS.remove(s.charAt(i));
            }
            i++;
            curString = curString.substring(1, curString.length());
            while(!contains(mapS, mapT) && j  < s.length()) {
                if(mapS.containsKey(s.charAt(j))) {
                    mapS.put(s.charAt(j), mapS.get(s.charAt(j)) + 1);
                } else {
                    mapS.put(s.charAt(j), 1);
                }
                curString += s.charAt(j);
                j++;
            }
            if(lowestString.length() > curString.length() && contains(mapS, mapT)) {
                lowestString = curString;
            }
            
        }
        return lowestString;
    }
    
    
    // if map1 contains map2, that is for every element in map2, map1 has a mapping for it and they both have the same result
    public boolean contains(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
        for(char key : map2.keySet()) {
            if(map1.containsKey(key)) {
                if(map1.get(key) < map2.get(key)) return false;
            } else {
                return false;
            }
        }
        return true;
        
    }
}
