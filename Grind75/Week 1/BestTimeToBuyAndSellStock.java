public class BestTimeToBuyAndSellStock {
    
}

// came back to it
class Solution {
    public int maxProfit(int[] prices) {
        int lowest = prices[0];
        int max = 0;
        
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lowest) {
                lowest = prices[i];
            } else if (prices[i] - lowest > max) {
                max = prices[i] - lowest;
            }
        }
        
        return max;
        
    }
}

// original solution

class Solution2 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = prices[0]; //since prices is of length at least 1
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] > min) {
                int p = prices[i] - min;
                if(p > profit) {
                    profit = prices[i] - min;
                }
            } else if (prices[i] < min) {
                min = prices[i];
            }
        }
        return profit;
        
    }
}
