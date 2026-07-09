class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        boolean[] ans = new boolean[queries.length];

        int[] comp = new int[n];
        int id = 0;

        for (int i = 1; i < n; i++) {
            if (Math.abs(nums[i] - nums[i - 1]) > maxDiff)
                id++;
            comp[i] = id;
        }

        int m = queries.length;

        for (int i = 0; i < m; i++) {
            if (queries[i][0] == queries[i][1]) {
                ans[i] = true;
                continue;
            }

            ans[i] = (comp[queries[i][0]] == comp[queries[i][1]]);
        }

        return ans;
    }
}