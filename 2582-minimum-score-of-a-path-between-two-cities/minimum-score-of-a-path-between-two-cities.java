class Solution {
    public int minScore(int n, int[][] roads) {

        // Adjacency List
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int wt = road[2];

            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n + 1];

        q.offer(1);
        vis[1] = true;

        int ans = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int[] it : adj.get(node)) {

                int next = it[0];
                int wt = it[1];

                ans = Math.min(ans, wt);

                if (!vis[next]) {
                    vis[next] = true;
                    q.offer(next);
                }
            }
        }

        return ans;
    }
}