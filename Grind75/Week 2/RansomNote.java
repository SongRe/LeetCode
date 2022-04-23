public class RansomNote {
    
}

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> available = new HashMap<>();
        
        
        for (int i = 0; i < magazine.length(); i++) {
            available.put(magazine.charAt(i), available.getOrDefault(magazine.charAt(i), 0) + 1);  
        }
        
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (!available.containsKey(c)) return false;
            available.put(c, available.get(c) - 1);
            if (available.get(c) < 0) {
                return false;
            }
        }
        
        return true;
    }
}
