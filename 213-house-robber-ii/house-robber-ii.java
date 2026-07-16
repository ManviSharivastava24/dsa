class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);

        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);

        int left = helper(nums, 1, n - 1, dp1);
        int right = helper(nums, 0, n - 2, dp2);

        return Math.max(left, right);
    }

    public int helper(int[] nums, int index, int end, int[] dp) {
        if (index > end)
            return 0;

        if (dp[index] != -1)
            return dp[index];

        int take = nums[index] + helper(nums, index + 2, end, dp);
        int notTake = helper(nums, index + 1, end, dp);

        return dp[index] = Math.max(take, notTake);
    }
}