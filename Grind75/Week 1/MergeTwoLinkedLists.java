public class MergeTwoLinkedLists {
    
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 ==  null) {
            return l1;
        }
        
        ListNode merged = new ListNode();
        if(l1.val <= l2.val) {
            merged.val = l1.val;
            merged.next = mergeTwoLists(l1.next, l2);
        } else {
            merged.val = l2.val;
            merged.next = mergeTwoLists(l1, l2.next);
        }
        return merged;
    }
}


// idea is to create a list, with the next element being the smaller between l1 and l2.  
