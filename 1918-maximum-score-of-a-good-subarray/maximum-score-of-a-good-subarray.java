class Solution {

    public int maximumScore(int[] nums, int k) {

        int n = nums.length;

        int[] prev = new int[n];
        int[] next = new int[n];

        Stack<Integer> st = new Stack<>();

        // Previous Smaller
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && nums[st.peek()] >= nums[i])
                st.pop();

            prev[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }

        st.clear();

        // Next Smaller
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && nums[st.peek()] >= nums[i])
                st.pop();

            next[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {

            int left = prev[i] + 1;
            int right = next[i] - 1;

            if (left <= k && k <= right) {

                int len = right - left + 1;

                ans = Math.max(ans, nums[i] * len);
            }
        }

        return ans;
    }
}