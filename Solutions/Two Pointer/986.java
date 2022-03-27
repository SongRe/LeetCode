import java.util.ArrayList;

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> result = new ArrayList<>();
        
        int i = 0, j = 0;
        while(i < firstList.length && j < secondList.length) {
            int firstLeft = firstList[i][0];
            int firstRight = firstList[i][1];
            int secondLeft = secondList[j][0];
            int secondRight = secondList[j][1];
            if(firstLeft > secondRight || secondLeft > firstRight) {
                //skip
            } else {
                result.add(getIntersect(firstList[i], secondList[j]));
            }
            
            if(firstRight > secondRight) {
                j++;
            } else if(firstRight < secondRight) {
                i++;
            } else if(firstLeft <= secondLeft) {
                i++;
            } else if(secondLeft <= firstLeft) {
                j++;
            }
            //firstList[i] is lower bound
            
        }

        int[][] res = new int[result.size()][2];
        for(int k = 0; k < result.size(); k++) {
            res[k] = result.get(k);
        }
        return res;
    }
    
    public int[] getIntersect(int[] first, int[] second) {
        int[] result = new int[2];
        
        //this function should always return an intersect, so should only be called if there's an intersection between the two intervals
        
        //decide which will be the starting 
        if(first[0] >= second[0] && first[0] <= second[1]) {
            result[0] = first[0];
        } else if(second[0] >= first[0] && second[0] <= first[1]) {
            result[0] = second[0];
        }
        
        //decide which will be ending point
        if(first[1] >= second[0] && first[1] <= second[1]) {
            result[1] = first[1];
        } else if(second[1] >= first[0] && second[1] <= first[1]) {
            result[1] = second[1];
        }
        
        return result;
    }
}
