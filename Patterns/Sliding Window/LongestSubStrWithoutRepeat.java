class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        String curString = "";

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(curString.indexOf(c) == -1) { //if the current character isn't in curString
                curString += c; //append it to curString;
            } else { //it is already in curString
                curString += c;
                curString = curString.substring(curString.indexOf(c) + 1); //then restart counting from 1 after the existing
            }
            if(max < curString.length()) {
                max = curString.length();
            }
            System.out.println(curString);
        }
        return max;
    }
}
