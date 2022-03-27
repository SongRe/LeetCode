public class FruitIntoBaskets {
    class Solution {
        public int totalFruit(int[] fruits) {
            int max = 0;
            
            HashMap<Integer, Integer> basket = new HashMap<>();
            
            int left = 0, right = 1;
            
            basket.put(fruits[0], 1);
            
            for(; right<fruits.length; right++){
                if(!basket.containsKey(fruits[right])){
                    if(basket.size() == 2){
                        max = Math.max(right - left, max);
                        
                        while(left < right){
                            basket.put(fruits[left], basket.get(fruits[left])-1);
                            
                            if(basket.get(fruits[left]) == 0)
                                basket.remove(fruits[left]);
                            
                             left++;
                            
                            if(basket.size() == 1)
                                break;
                        }
                    }
                    basket.put(fruits[right], 1);
                }
                else
                    basket.put(fruits[right], basket.get(fruits[right])+1);
            }
            
            max = Math.max(max, right - left);
            
            return max;
        }
    }


    class MySolution {
        public int totalFruit(int[] fruits) {
            int maxCount = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            int i = 0;
            for(int j = 0; j < fruits.length; j++) {
                int curFruit = fruits[j];
                if(map.containsKey(curFruit)) {
                    map.put(curFruit, map.get(curFruit) + 1);
                } else {
                    map.put(curFruit, 1);
                }
                
                while(map.size() > 2) {
                    int startFruit = fruits[i];
                    map.put(startFruit, map.get(startFruit) - 1);
                    if(map.get(startFruit) == 0) {
                        map.remove(startFruit);
                    }
                    i++;
                }
                maxCount = Math.max(maxCount, j - i + 1);
            }
            return maxCount;
        }
    }
}
