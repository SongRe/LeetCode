public class LongestRepeatingCharWithKReplace {
    
}

class Solution {
    public int characterReplacement(String s, int k) {
        int left=0;
        int right=0;
        int max_repeated=Integer.MIN_VALUE;
        int max_length=Integer.MIN_VALUE;
        HashMap<Character,Integer>map=new HashMap<>();
        
        while(right<s.length()){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            max_repeated=Math.max(max_repeated,map.get(s.charAt(right)));
            if(right-left+1-max_repeated>k){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                left++;
            }
            max_length=Math.max(max_length,right-left+1);
            right++;
        }
        return max_length;
    }
}
