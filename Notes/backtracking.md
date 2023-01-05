Backtracking
- recursively, keep track of a path and a current node.
- the method will take in the current total path taken, as well as the current node we're at in the graph.
	- we will have a terminating condition (to return as needed)
	- call backtrack method on each of the current node's neighbors (to explore their respective paths)
		- to do this we can add the neighboring node to the path, call backtrack() with the neighbor node and updated path, then pop it off the path (backtrack) after traversing.
```python
class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:

        target = len(graph) - 1
        results = []

        def backtrack(curr_node, path):
            # if we reach the target, no need to explore further.
            if curr_node == target:
                results.append(list(path))
                return
            # explore the neighbor nodes one after another.
            for next_node in graph[curr_node]:
                path.append(next_node)
                backtrack(next_node, path)
                path.pop()
        # kick of the backtracking, starting from the source node (0).
        path = [0]
        backtrack(0, path)

        return results
```


## dfs using words ?
```python
class Solution:
    def longestPalindrome(self, words: List[str]) -> int:
        result = 0
        foundPalindromes = []
        
        def isPalindrome(s: str) -> bool:
            nonlocal foundPalindromes
            if (s in foundPalindromes):
                return True
            left = 0
            right = len(s) - 1
            while (left < right):
                if s[left] != s[right]:
                    return False
                left += 1
                right -= 1
            foundPalindromes.append(s)
            return True
        
        def backtrack (curString):
            nonlocal words
            nonlocal result
            if isPalindrome(curString) and len(curString) > 0:
                result = max(result, len(curString))
            for word in words:
                words.remove(word)
                backtrack(curString + word)
                words.append(word)
        # wordsUsed = []
        backtrack("")
        return result
        ```
## Boards / Matrices
We can optimize our visited tracking by just changing the value of the board itself in place, then reverting it afterwards
