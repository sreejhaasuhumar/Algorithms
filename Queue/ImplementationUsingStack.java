package Queue;

import java.util.Stack;

public class ImplementationUsingStack {

private Stack<Integer> s1 = new Stack<>();
private Stack<Integer> s2 = new Stack<>();
int front = 0;
    
    public void push(int x) {
        if(s1.isEmpty())
        {
            front = x;
        }
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while(!s2.isEmpty()) {
            s1.push(s2.pop());  
        }
    }
    
    public int pop() {
        return s1.pop();
    }
    
    public int peek() {
        return s1.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty();
        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

 /* Logic:
 * 1. We maintain two stacks, s1 and s2.
 * 2. Push Operation:
 *  - When pushing an element x, we check if s1 is empty. If it is, we update the front variable to x (to keep track of the front element). 
 * Then, we transfer all elements from s1 to s2, push x onto s1, and then transfer all elements back from s2 to s1. This ensures that the newest element is at the bottom of s1, maintaining the queue order.
 * 3. Pop Operation:
 *  - To pop an element, we simply pop the top element from s1, which is the front of the queue.
 * 4. Peek Operation:
 *  - To get the front element without removing it, we return the top element of s1.
 * 5. Empty Operation:
 *  - The empty operation checks if s1 is empty, indicating whether the queue is empty or not.
 * Time Complexity:
 * Push: O(n) - due to transferring elements between stacks.
 * Pop: O(1) - direct pop from the top of the stack.
 * Peek: O(1) - direct access to the top of the stack.   
 * Empty: O(1) - direct check if the stack is empty.
 * Space Complexity: O(n) - for storing elements in the stack.
 */
