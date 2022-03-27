Binary Tree
-- 

Symmetric Tree
- recursive function check(node r1, node r2)
- if both r1 and r2 are null, then return true 
- else if r1 or r2 are null, then return false(one is nonull, one is null)
- else if r1 == r2, then return check(r1.right, r2.left) && check(r1.left, r2.right)

HasPathSum
- 
