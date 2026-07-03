import java.util.*;

class Solution {

    static class Edge {
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static class Path {
        int node;
        long cost;

        Path(int node, long cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {

        int m = edges.length;
        int n = online.length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {

            int u = edges[i][0];
            int v = edges[i][1];
            int c = edges[i][2];

            if (online[v]) {
                adj.get(u).add(new Edge(v, c));
            }

            min = Math.min(min, c);
            max = Math.max(max, c);
        }

        int left = min;
        int right = max;
        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (canFind(adj, k, mid, n)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    private boolean canFind(List<List<Edge>> adj, long k, int x, int n) {

        long[] visited = new long[n];
        Arrays.fill(visited, k + 1);

        Queue<Path> queue = new ArrayDeque<>();
        queue.offer(new Path(0, 0));

        while (!queue.isEmpty()) {

            Path cur = queue.poll();

            if (visited[cur.node] < cur.cost)
                continue;

            if (cur.node == n - 1)
                return true;

            for (Edge e : adj.get(cur.node)) {

                if (e.cost < x)
                    continue;

                long alt = cur.cost + e.cost;

                if (visited[e.to] > alt) {
                    visited[e.to] = alt;
                    queue.offer(new Path(e.to, alt));
                }
            }
        }

        return false;
    }
}