package Grind75.Week 1;

public class LinkedListCycle {
    
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head.next;
        while (head != null && fast != null) {
            if (fast == head) return true;
            head = head.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                fast = fast.next;
            }
        }
        return false;
    }
    
}
