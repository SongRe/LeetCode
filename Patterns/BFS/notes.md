Breadth-First Search
Primary Uses:
- Traversing all nodes in a graph
- Finding shortest path, where all edges have equal and positive weights. 

We think instead a graph as a tree, travering level by level. From a starting node, we consider all nodes a distance of i away, a part of level i.
- We use a queue instead of a stack
Traversing all nodes in a path:
1. Mark starting node as visited
2. enqueue all nodes that are 1 distance away
3. While (queue is not empty, repeat from 3 to 7)
4. Pop node off queue
5. If visited, return and dont do anything
6. If not visited, mark as visited
7. Enqueue all nodes that are 1 distance away   
8. If queue is empty, then we have visited all nodes in the graph

Finding shortest path:
1. Enqueue starting node
2. while queue is not empty, repeat steps 3 to 5.
3. Pop off queue, mark current node (end of path in queue) as visited
4. If current node (end of path in queue) is destination, return this path (it is the shortest)
5. Enqueue all possible next paths (current node + neighbors) if the neighbor has not been visited
6. End
