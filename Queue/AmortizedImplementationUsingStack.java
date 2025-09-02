package Queue;

import java.util.Stack;

public class AmortizedImplementationUsingStack {

private Stack<Integer> s1 = new Stack<>();
private Stack<Integer> s2 = new Stack<>();
int front = 0;
    
    public void push(int x) {
        if(s1.isEmpty())
        {
            front = x;
        }
        s1.push(x);  
    }
    
    public int pop() {
        if(s2.isEmpty()) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    
    public int peek() {
        if(!s2.isEmpty()) {
            return s2.peek();
        }
        return front;
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
        
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
 *  - When pushing an element x, we check if s1 is empty. If it is, we update the front variable to x (to keep track of the front element). Then, we push x onto s1.
 * 3. Pop Operation:
 *  - To pop an element, we first check if s2 is empty. If it is, we transfer all elements from s1 to s2 by popping from s1 and pushing onto s2. This reverses the order of elements, making the oldest element (the front of the queue) accessible at the top of s2. Finally, we pop the top element from s2.
 * 4. Peek Operation:
 *  - To get the front element without removing it, we check if s2 is not empty. If it is not empty, we return the top element of s2. If s2 is empty, we return the front variable, which holds the front element of the queue.
 * 5. Empty Operation:
 *  - The empty operation checks if both s1 and s2 are empty, indicating whether the queue is empty or not.
 * Time Complexity:
 * Push: O(1) - direct push onto s1.
 * Pop: Amortized O(1) - while transferring elements from s1 to s2 takes O(n), each element is moved at most once, leading to an average time of O(1) per pop operation.
 * Peek: O(1) - direct access to the top of s2 or the front variable.
 * Empty: O(1) - direct check if both stacks are empty.
 * Space Complexity: O(n) - for storing elements in the two stacks.
 */