## Best Team with no conflicts
https://leetcode.com/problems/best-team-with-no-conflicts/


```python
from typing import List
class Solution:
    def bestTeamScore(self, scores: List[int], ages: List[int]) -> int:
        n = len(scores)
        dp = [0] * n
        ans = 0
        players = sorted(zip(ages, scores))
        players.sort(key = lambda x: x[0])
        for i in range(n):
            # current player default score
            dp[i] = players[i][1]
            for j in range(i):
                if players[j][1] <= players[i][1]:
                    # if player age score is less than curplayer age
                    # the maximum we can get by adding our player is calculated this way:
                    dp[i] = max(dp[i], dp[j] + players[i][1])
            ans = max(ans, dp[i])
        return ans/
```
So the idea is to first sort the players by age -> score. 
Next, we iterate through the array, and we'll want to update the dp array as we go. 
By default, dp[i] is the player i's score. 
We will go from 0 -> i, and if there is player there who's score is less than our current player, we let dp[i] be the max between our current score and what our score WOULD BE if we add the current player to j's team. 

Return the maximum in the dp array at the end. 
