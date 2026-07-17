class Solution {
    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == '1') {

                    count++;

                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    grid[i][j] = '0';

                    int[] dx = {-1, 0, 1, 0};
                    int[] dy = {0, 1, 0, -1};

                    while (!q.isEmpty()) {

                        int[] cur = q.poll();

                        int x = cur[0];
                        int y = cur[1];

                        for (int k = 0; k < 4; k++) {

                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if (nx >= 0 && nx < n &&
                                ny >= 0 && ny < m &&
                                grid[nx][ny] == '1') {

                                grid[nx][ny] = '0';
                                q.offer(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}