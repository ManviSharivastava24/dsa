class Solution {

    ArrayList<Integer>[] graph;
    boolean[] vis;

    int nodes;
    int edges;

    public int countCompleteComponents(int n, int[][] edgesArr) {

        graph = new ArrayList[n];
        vis = new boolean[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edgesArr) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {

            if (!vis[i]) {

                nodes = 0;
                edges = 0;

                dfs(i);

                edges /= 2;

                if (edges == nodes * (nodes - 1) / 2)
                    ans++;
            }
        }

        return ans;
    }

    void dfs(int u) {

        vis[u] = true;
        nodes++;

        edges += graph[u].size();

        for (int v : graph[u]) {
            if (!vis[v])
                dfs(v);
        }
    }
}