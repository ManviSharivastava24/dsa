class Solution {

    class Pair {
        int r, c, cost;

        Pair(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }

    public int swimInWater(int[][] grid) {

        int n = grid.length;

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.cost - b.cost);

        int[][] vis = new int[n][n];

        pq.add(new Pair(0, 0, grid[0][0]));

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {

            Pair cur = pq.poll();

            int r = cur.r;
            int c = cur.c;
            int cost = cur.cost;

            if (vis[r][c] == 1)
                continue;

            vis[r][c] = 1;

            if (r == n - 1 && c == n - 1)
                return cost;

            for (int k = 0; k < 4; k++) {

                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n
                        && vis[nr][nc] == 0) {

                    pq.add(new Pair(
                            nr,
                            nc,
                            Math.max(cost, grid[nr][nc])
                    ));
                }
            }
        }

        return -1;
    }
}