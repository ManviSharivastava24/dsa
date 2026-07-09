class Solution {

    int[] dp;

    public int jump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solve(0, nums);
    }

    int solve(int idx, int[] nums) {

        if (idx >= nums.length - 1)
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        int ans = Integer.MAX_VALUE;

        for (int jump = 1;
             jump <= nums[idx] && idx + jump < nums.length;
             jump++) {

            int next = solve(idx + jump, nums);

            if (next != Integer.MAX_VALUE) {
                ans = Math.min(ans, 1 + next);
            }
        }

        return dp[idx] = ans;
    }
}
