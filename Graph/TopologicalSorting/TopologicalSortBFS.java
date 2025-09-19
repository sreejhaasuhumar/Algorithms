package Graph.TopologicalSorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* Topological Sorting using BFS (Kahn's Algorithm)
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

public class TopologicalSortBFS {
    public static List<Integer> topologicalSort(List<List<Integer>> adj) {
        int n = adj.size();
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[n];

        for(int i=0; i<n;i++) {
            for(int j: adj.get(i)) {
                inDegree[j]++;
            }
        }

        for(int i=0;i<n;i++) {
            if(inDegree[i]==0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            result.add(node);
            for(int i:adj.get(node)){
                inDegree[i]--;
                if(inDegree[i]==0) {
                    queue.add(i);
                }
            }
        }

        if (result.size() != n) {
            throw new RuntimeException("Graph is not a DAG - cycle detected!");
        }
        
        return result;
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
 * 1. Calculate in-degrees of all vertices.
 * 2. Initialize a queue and enqueue all vertices with in-degree 0.
 * 3. While the queue is not empty:
 *    - Dequeue a vertex, add it to the topological order.
 *    - Decrease the in-degree of its neighbors by 1.
 *    - If any neighbor's in-degree becomes 0, enqueue it.
 * 4. If the topological order contains all vertices, return it; otherwise, the graph has a cycle.
 * Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges.
 * Space Complexity: O(V) for the in-degree array and the queue.
*/
