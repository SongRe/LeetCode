package Patterns.Recursion;

public class PascalTriangle {
    
}
class Solution {
    //List<List<Integer>> rows = new ArrayList<>();

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            return row;
        }
        if (rowIndex == 1) {
            List<Integer> row = new ArrayList<>();
            
            row.add(1);
            row.add(1);
            return row;
        }
        List<Integer> prev = getRow(rowIndex - 1);
//         if (rows.size() > rowIndex - 1) {
            
//         } else {
//             prev = getRow(rowIndex - 1);
//         }
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            if(i == 0 || i == rowIndex) {
                row.add(1);
            } else {
                row.add(prev.get(i - 1) + prev.get(i));
            }
        }
        return row;
        
    }
}
