Solutions
--



$33$

$153$

- Solution idea is to deductively break the array down into intervals through binary search. For example, if nums[mid] > nums[r], then we know that the minimum element must be in between mid and r, nums[mid] excluded.  
- If nums[mid] < nums[left], then the minimum element must be in between mid and left, nums[mid] included. 

$162$

A peak element is an element that is strictly greater than its neighbors.

Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞.

You must write an algorithm that runs in O(log n) time.

- Solution idea is to check the middle for a peak. If nums[mid] is a peak, then return mid. If it isn't, change the search to search in the half of the array that has the value greater than nums[mid]. For example, if nums[mid + 1] > nums[mid], then repeat the search for the peak from (mid + 1) to (right). 

$82$

Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

- Solution idea: keep track of a "predecessor" or "prev" node that points to the last node with distinct value. Then, simply iterate through the linked list and skip all values for which the next value is equal to the current value. We do nothing but move if the next node's value is equal to current node value
- Once we're finished moving, we set prev.next = head.next, like a "potential" next node. If we find, that on the next iteration, the condition (head.val == head.next.val) no longer holds true, then set prev = prev.next and continue iteration. 

$15$
3Sum
--
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

- Solution:
- Sort the array.
- Two loops, three pointers, i, j, k. i will be the outer loop that iterates through the array, while j = i + 1 and k = last index of array
- To skip duplicates, we increment i (i.e do nothing) as long as nums[i] == nums[i - 1]. 
- Inner loop: while (k > j), we process 3 outcomes:
  - The sum (num[i] + num[j] + num[k] == 0), so add this result, decrement k by 1 and decrement k further by 1 until nums[k] != nums[k + 1].
  - The sum < 0, so increment j by 1.
  - The sum > 0, so decrement k by 1.

$844$ 

Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

- Solution: one pointer for each string s,t.
- We start at back of string, iterate forward, and always look for the next guaranteed character (if there is a '#', decrement i/j and add 1 to the skipCount for that string)
  - if the skipCount > 0, then we decrement skipCount and i/j.
  - else break, we found a guaranteed character
- do the comparison between characters in the string
- handle edge cases where only one of i/j < 0. (return false in this case)



$349$

Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

Initial Solution: Sort both arrays, iterate through both arrays at the same time and add equal elements to a set. Return the set as an array
- i in num1 and j in nums2
- while(i < nums1.length && j < nums2.length) 
  - if nums1[i] < nums2[j], then i++
  - if nums1[i] > nums2[j], then j++
  - if nums1[i] = nums2[j], then add nums[i] to the set of intersect elements

Given solution:
- Iterate through both arrays and all elements to their respective sets, use builtin set.retainAll(set) to get intersection, return the intersection set as an array.

