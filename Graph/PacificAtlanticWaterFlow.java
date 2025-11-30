package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Given a matrix of heights, we want to find all the cells that can flow to both the Pacific and Atlantic oceans.
    * The Pacific ocean touches the left and top edges of the matrix, and the Atlantic ocean touches the right and bottom edges.
    * Water can only flow from a cell to another one with height equal or lower.
    * We can use DFS or BFS to explore the cells that can reach each ocean starting from the edges.
    * Finally, we find the intersection of cells that can reach both oceans.
    * Example:
    * Input:
    * heights = [
    *   [1,2,2,3,5],
    *   [3,2,3,4,4],
    *   [2,4,5,3,1],
    *   [6,7,1,4,5],
    *   [5,1,1,2,4]
    * ]
    * Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
    * Explanation: The cells that can flow to both oceans are marked in the output.
    * Note:
    * The order of returned grid coordinates does not matter.
    * Both m and n are less than 150.           
 */

public class PacificAtlanticWaterFlow {
    // Implementation can be added here
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return new ArrayList<>();
        }
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0);
            dfs(heights, atlantic, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j);
            dfs(heights, atlantic, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, boolean[][] ocean, int i, int j) {
        ocean[i][j] = true;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < heights.length && y >= 0 && y < heights[0].length
                    && !ocean[x][y] && heights[x][y] >= heights[i][j]) {
                dfs(heights, ocean, x, y);
            }
        }
    }
}

/* time complexity: O(m * n)
   space complexity: O(m * n)
 */
