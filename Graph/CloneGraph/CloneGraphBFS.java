package Graph.CloneGraph;
/* 
 * Clone Graph using BFS
  * Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph. Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
  * Example:
  * Input:
  *     1
  *   /   \
  *  2 --- 3
  *  |     |
  *  4 ---/
  * Output: A deep copy of the graph.
  * Explanation: The graph is represented in the test case using an adjacency list.
  * Note:
  * The number of nodes will be between 1 and 100.
  * The undirected graph is a simple graph, which means no repeated edges and no self-loops in the graph.
  * Since the graph is undirected, if node p has node q as neighbor, then node q must have node p as neighbor too.
  * You must return the copy of the given node as a reference to the cloned graph.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraphBFS {
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList();

        Node clone = new Node(node.val);
        visited.put(node, clone);
        queue.add(node);

        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            for(Node neighbor: curr.neighbors) {
                if(!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                visited.get(curr).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }
    
}

/* Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges.
 * Space Complexity: O(V) for the visited map and the queue.
 */