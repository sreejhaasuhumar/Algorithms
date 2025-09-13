public class MergeLinkedListRecursive {
    public ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode handler;
        if(l1.val < l2.val) {
            handler = l1;
            handler.next = mergeTwoListsRecursive(l1.next, l2);
        } else {
            handler = l2;
            handler.next = mergeTwoListsRecursive(l1, l2.next);
        }
        return handler;
	}
    
}

/* Logic
 * Recursively compare the heads of both lists and link the smaller node to the result of merging the rest of the lists.
 * Time Complexity: O(n + m) where n and m are the lengths of the two lists.
 * Space Complexity: O(n + m) due to recursive call stack.
 */
