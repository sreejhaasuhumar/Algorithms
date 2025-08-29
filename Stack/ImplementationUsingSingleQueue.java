import java.util.LinkedList;
import java.util.Queue;

public class ImplementationUsingSingleQueue { 
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        ImplementationUsingSingleQueue myStack = new ImplementationUsingSingleQueue();
        myStack.push(1);
        myStack.push(2);
        myStack.top(); // return 2
        myStack.pop(); // return 2
        myStack.empty(); // return False

    }
    private static Queue<Integer> queue = new LinkedList<>();
    // Push element x onto stack.
    public void push(int x) {
        queue.add(x);
        for (int i=1; i<queue.size(); i++)
            queue.add(queue.remove());
    }

    // Removes the element on top of the stack and returns that element.
    public int pop() {
        return queue.remove();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Returns whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }

}

/* Single Queue Logic:
 * 1. We maintain a single queue to simulate stack behavior.
 * 2. Push Operation:
 *   - When pushing an element x, we first add it to the queue.
 *   - Then, we rotate the queue by removing elements from the front and adding them back to the end of the queue. This is done for (size-1) times, effectively moving the newly added element to the front of the queue.
 * 3. Pop Operation:
 *  - To pop an element, we simply remove the front element from the queue, which is the top of the stack.
 * 4. Top Operation:
 *  - The top operation returns the front element of the queue without removing it, which represents the top of the stack.
 * 5. Empty Operation:
 *  - The empty operation checks if the queue is empty, indicating whether the stack is empty or not.    
 * Time Complexity:
 * Push: O(n) - due to rotating the queue.
 * Pop: O(1) - direct removal from the front of the queue.
 * Top: O(1) - direct access to the front of the queue.   
 * Empty: O(1) - direct check if the queue is empty.
 * Space Complexity: O(n) - for storing elements in the queue.
 */