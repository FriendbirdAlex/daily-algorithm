class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        if (freshCount == 0) {
            return 0;
        }
        int minutes = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


        while (!queue.isEmpty() && freshCount > 0) {
            minutes++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] orange = queue.poll();
                int r = orange[0];
                int c = orange[1];


                for (int[] dir : directions) {
                    int newR = r + dir[0];
                    int newC = c + dir[1];


                    if (newR >= 0 && newR < rows && newC >= 0 && newC < cols
                            && grid[newR][newC] == 1) {

                        grid[newR][newC] = 2;
                        freshCount--;
                        queue.offer(new int[]{newR, newC});
                    }
                }
            }
        }
        return freshCount == 0 ? minutes : -1;
    }
}
