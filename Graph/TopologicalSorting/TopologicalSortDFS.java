package Graph.TopologicalSorting;

import java.util.*;
/* Topological Sorting using DFS 
    * Given a Directed Acyclic Graph (DAG), perform a topological sort of the graph.
    * Note: Use the adjacency list representation of the graph.
    * Example:
    * Input: adj[][] = [[], [], [3], [1], [0,1], [0,2]]
    * Output: A possible topological order is [5, 4, 2, 3, 1, 0]
    * Explanation: The graph can be visualized as:
    * So one valid topological ordering is 5, 4, 2, 3, 1, 0
    * Note that there can be multiple valid topological
    * orderings for a given graph
*/

public class TopologicalSortDFS {

    public static List<Integer> topologicalSort(List<List<Integer>> adj) {
        int n = adj.size();
        boolean[] visited = new boolean[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                dfs(adj, i, visited, stack);
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    public static void dfs(List<List<Integer>> adj, int node, boolean[] visited, Deque<Integer> stack) {
        visited[node] = true;
        for(int i: adj.get(node)) {
            if(!visited[i]) {
                dfs(adj, i, visited, stack);
            }
        }
        stack.push(node);
    }
    public static void main(String[] args) {
        // Example graph (6 nodes: 0..5)
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 6; i++) adj.add(new ArrayList<>());

        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        List<Integer> order = topologicalSort(adj);
        System.out.println("Topological Order: " + order);
    }
}

/* Logic    
 * 1. Create a boolean array to track visited nodes and a stack to store the topological order.
 * 2. For each unvisited node, perform a DFS:
 *    - Mark the node as visited.
 *    - Recursively visit all its unvisited neighbors.
 *    - After visiting all neighbors, push the node onto the stack.
 * 3. Once all nodes are processed, pop elements from the stack to get the topological order.
 * Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges.
 * Space Complexity: O(V) for the visited array and the stack.
 */

