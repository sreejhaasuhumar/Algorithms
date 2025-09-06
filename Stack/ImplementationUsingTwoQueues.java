package Stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementationUsingTwoQueues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ImplementationUsingTwoQueues myStack = new ImplementationUsingTwoQueues();
		myStack.push(1);
		myStack.push(2);
		myStack.top(); // return 2
		myStack.pop(); // return 2
		myStack.empty(); // return False

	}
	private static Queue<Integer> q1 = new LinkedList<>();
	private static Queue<Integer> q2 = new LinkedList<>();
	private static int top;

    // Push element x onto stack.
    public void push(int x) {
        q2.add(x);
        top = x;
        
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        
        // Swap the names of the two queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Removes the element on top of the stack and returns that element.
    public int pop() {
        int poppedElement = q1.remove();
        
        // Update the top element
        if (!q1.isEmpty()) {
            top = q1.peek();
        }
        
        return poppedElement;
    }

    // Get the top element.
    public int top() {
        return top;
    }

    // Returns whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }

}

/* Two Queue Logic:
 * 1. We maintain two queues, q1 and q2. The main queue (q1) holds the stack elements, while the auxiliary queue (q2) is used for rearranging elements during the push operation.
 * 2. Push Operation:
 *   - When pushing an element x, we first add it to q2.
 *  - Then, we transfer all elements from q1 to q2. This ensures that the newly added element x is at the front of q1 when we swap the queues.
 *  - Finally, we swap the names of q1 and q2, making q1 the main queue with the new element on top.
 * 3. Pop Operation:
 *  - To pop an element, we simply remove the front element from q1, which is the top of the stack.
 *  - We also update the top variable to reflect the new top element after popping.
 * 4. Top Operation:
 *  - The top operation returns the value of the top variable, which always holds the current top element of the stack.
 * 5. Empty Operation:
 *  - The empty operation checks if q1 is empty, indicating whether the stack is empty  or not.    
 * Time Complexity:
 * Push: O(n) - due to transferring elements between queues.
 * Pop: O(1) - direct removal from the front of the queue.
 * Top: O(1) - direct access to the top variable.   
 * Empty: O(1) - direct check if the queue is empty.
 * Space Complexity: O(n) - for storing elements in the queues.
 */