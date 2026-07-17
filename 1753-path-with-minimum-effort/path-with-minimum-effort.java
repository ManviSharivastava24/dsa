
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        //in pq we are storing (x,y,maxefforttillnow);
        pq.add(new int[] { 0, 0, 0 });
        int effort[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                effort[i][j] = Integer.MAX_VALUE;
            }
        }
        effort[0][0] = 0;
        effort[0][0] = 0;
        int dx[] = { -1, 0, 1, 0 };
        int dy[] = { 0, 1, 0, -1 };
        while (!pq.isEmpty()) {
            int[] curr = pq.remove();
            int x = curr[0];
            int y = curr[1];
            int eff = curr[2];
            // if (x == n - 1 && y == m - 1) {
            //     return eff;
            // }
            for (int i = 0; i < 4; i++) {
                int newx = x + dx[i];
                int newy = y + dy[i];

                if (newx >= 0 && newy >= 0 && newx < n && newy < m) {
                    int possibleneweff = Math.abs(heights[newx][newy] - heights[x][y]);
                    int neweff = Math.max(possibleneweff, eff);
                    if (effort[newx][newy] > neweff) {
                        effort[newx][newy] = neweff;
                        pq.add(new int[] { newx, newy, neweff });
                    }

                }

            }
        }
        return effort[n - 1][m - 1];
    }
}