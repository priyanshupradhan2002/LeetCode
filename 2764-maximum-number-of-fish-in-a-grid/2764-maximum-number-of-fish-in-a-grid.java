class Solution {
    // Helper function for DFS
    private int dfs(int[][] grid, boolean[][] visited, int r, int c, int[][] directions) {
        int m = grid.length;
        int n = grid[0].length;

        if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c] || grid[r][c] == 0) {
            return 0;
        }

        visited[r][c] = true; // Mark the cell as visited
        int totalFish = grid[r][c]; // Catch fish in the current cell

        // Explore all adjacent cells
        for (int[] dir : directions) {
            totalFish += dfs(grid, visited, r + dir[0], c + dir[1], directions);
        }
        return totalFish;
    }

    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n]; // To track visited cells
        int maxFish = 0;

        // Direction vectors for moving up, right, down, left
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        // Iterate through all cells in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    // Start DFS from the water cell
                    maxFish = Math.max(maxFish, dfs(grid, visited, i, j, directions));
                }
            }
        }

        return maxFish;
    }
}
