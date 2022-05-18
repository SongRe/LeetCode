/**
 * Definition for singly-linked list.

 */

 // we think from end of list to start
 // assume that everything up until head is already reversed
 // head.next.next = head sets head.next's next to us
 // then we set head's next to null to prevent looping
 
  public class ListNode {
      int val;
      ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
        
    }

    public ListNode reverseListIter(ListNode head) {
        ListNode next = null;
        ListNode prev = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
