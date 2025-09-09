/* 
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. 
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to. 
 * Note that pos is not passed as a parameter.
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 */

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
            {
                return true;
            }
        }
        return false; 
    }
}

/* Logic
 * Use two pointers, one moving twice as fast as the other. If there is a cycle, they will eventually meet.
 * If the fast pointer reaches the end of the list, there is no cycle.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
