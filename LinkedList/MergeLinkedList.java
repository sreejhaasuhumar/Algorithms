/*
 * Problem Statement: Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.
 * Example: Input: l1 = [1,2,4], l2 = [1,3,4], Output: [1,1,2,3,4,4]
 * LeetCode Link: https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeLinkedList {
    
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode handler = head;
        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                handler.next = l1;
                l1 = l1.next;
            } else {
                handler.next = l2;
                l2 = l2.next;
            }
            handler = handler.next;
        }
        
        if (l1 != null) {
            handler.next = l1;
        } else if (l2 != null) {
            handler.next = l2;
        }
        
        return head.next;
    }
	
}

/* Logic
 * Use a dummy head to simplify the merging process. Compare the nodes of both lists and append the smaller one to the merged list.
 * Time Complexity: O(n + m) where n and m are the lengths of the two lists.
 * Space Complexity: O(1) since we are reusing the existing nodes.
 */