class Solution {
    public int countCompleteComponents(int n, int[][] edges) {

        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        boolean[] vis = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {

            if (vis[i])
                continue;

            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            vis[i] = true;

            int nodes = 0;
            int degreeSum = 0;

            while (!q.isEmpty()) {

                int curr = q.poll();
                nodes++;

                degreeSum += graph[curr].size();

                for (int nei : graph[curr]) {
                    if (!vis[nei]) {
                        vis[nei] = true;
                        q.offer(nei);
                    }
                }
            }

            int edgeCount = degreeSum / 2;

            if (edgeCount == nodes * (nodes - 1) / 2)
                ans++;
        }

        return ans;
    }
}