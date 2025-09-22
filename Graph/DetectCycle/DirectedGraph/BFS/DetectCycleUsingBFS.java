package Graph.DetectCycle.DirectedGraph.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* Detect Cycle in a Directed Graph using BFS (Kahn's Algorithm)
    * Given a directed graph, check if it contains a cycle.
    * Note: Use the adjacency list representation of the graph.
    * Example:
    * Input: adj[][] = [[], [2], [3], [1]]
    * Output: true (The graph contains a cycle: 1 -> 2 -> 3 -> 1)
    * Explanation: The graph can be visualized as:
    * So the graph contains a cycle.
    * Another Example:
    * Input: adj[][] = [[], [2], [3], []]
    * Output: false (The graph does not contain any cycle)
    * Explanation: The graph can be visualized as:
    * So the graph does not contain any cycle.
*/
public class DetectCycleUsingBFS {
    public static boolean hasCycle(List<List<Integer>> adj) {
        int n = adj.size();
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j : adj.get(i)) {
                inDegree[j]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return count != n; // If count is not equal to number of nodes, there is a cycle
    }

    public static void main(String[] args) {
        // Example graph with a cycle
        List<List<Integer>> adjWithCycle = new ArrayList<>();
        for (int i = 0; i < 4; i++) adjWithCycle.add(new ArrayList<>());
        adjWithCycle.get(1).add(2);
        adjWithCycle.get(2).add(3);
        adjWithCycle.get(3).add(1);

        System.out.println("Graph contains cycle: " + hasCycle(adjWithCycle)); // Output: true

        // Example graph without a cycle
        List<List<Integer>> adjWithoutCycle = new ArrayList<>();
        for (int i = 0; i < 4; i++) adjWithoutCycle.add(new ArrayList<>());
        adjWithoutCycle.get(1).add(2);
        adjWithoutCycle.get(2).add(3);

        System.out.println("Graph contains cycle: " + hasCycle(adjWithoutCycle)); // Output: false
    }


}
