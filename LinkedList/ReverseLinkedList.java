/* Problem Statement: Reverse a singly linked list.
 * Example: Input: 1->2->3->4->5->NULL, Output: 5->4->3->2->1->NULL
 * LeetCode Link: https://leetcode.com/problems/reverse-linked-list/
 */

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}

/* Logic
 * Use three pointers: prev, curr, and next. Iterate through the list, reversing the next pointer of each node.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

