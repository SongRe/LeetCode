$80$

<p>

Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

<p>

- Initial solution: Replace all duplicates (more than 2 of the same) with Integer.MAX or some char '_', then sort it again at the end
- Optimal Solution: Two pointers, i, and index
- The idea is to iterate through with i and keep index pointing to the last non-duplicate of the array 
1. Initialize both to start at 2, reject any nums.length <= 2.
2. if at any time, nums[i] != nums[index - 2],  make nums[index] = nums[i] and increment index by 1.
3. Return index

$349$

You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.

The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].

Brute force approach, where we have two pointers, i and j, that traverse the given 2D array.
- if the left bound firstList[i] > right bound of secondList[j], then we do nothing
- Similarly, if the left bound of secondList[j] > firstList[i], then we do nothing
- If neither condition is saisfied, then there must be a intersect, so we use the getIntersect() method and add it to our results.
- Finally, increment i and j based on whichever right bound of firstList[i] or secondList[j] is lower, then left bound respectively, if they are equal.
- So if right bound of firstList[i] < rightBound of secondList[j], then increment i. 

$160$
Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

The test cases are generated such that there are no cycles anywhere in the entire linked structure.

Note that the linked lists must retain their original structure after the function returns.
