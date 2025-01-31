//import java.util.*;

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int islandId = 2; // Start labeling from 2 (0 and 1 already used)
        Map<Integer, Integer> islandSizes = new HashMap<>();
        int maxIsland = 0;

        // Step 1: Find all islands and label them with unique IDs
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, islandId);
                    islandSizes.put(islandId, size);
                    maxIsland = Math.max(maxIsland, size);
                    islandId++;
                }
            }
        }

        // Step 2: Check every 0 and calculate possible max island size
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> connectedIslands = new HashSet<>();
                    int newSize = 1; // Change 0 to 1

                    for (int[] d : directions) {
                        int x = i + d[0], y = j + d[1];
                        if (isValid(grid, x, y) && grid[x][y] > 1) {
                            connectedIslands.add(grid[x][y]);
                        }
                    }

                    for (int id : connectedIslands) {
                        newSize += islandSizes.get(id);
                    }

                    maxIsland = Math.max(maxIsland, newSize);
                }
            }
        }

        return maxIsland;
    }

    // DFS to label islands
    private int dfs(int[][] grid, int i, int j, int id) {
        if (!isValid(grid, i, j) || grid[i][j] != 1) return 0;
        grid[i][j] = id; // Mark visited with island ID
        int size = 1;
        for (int[] d : directions) {
            size += dfs(grid, i + d[0], j + d[1], id);
        }
        return size;
    }

    // Check if position is inside the grid
    private boolean isValid(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }

    // 4-directional moves
    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
}
