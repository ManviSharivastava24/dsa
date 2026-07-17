class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        // Frequency of each number
        int[] freq = new int[max + 1];
        for (int x : nums) freq[x]++;

        // cnt[d] = numbers divisible by d
        long[] cnt = new long[max + 1];
        for (int d = 1; d <= max; d++) {
            for (int j = d; j <= max; j += d) {
                cnt[d] += freq[j];
            }
        }

        // exactPairs[d] = pairs having gcd exactly d
        long[] exactPairs = new long[max + 1];

        for (int d = max; d >= 1; d--) {
            long total = cnt[d] * (cnt[d] - 1) / 2;

            for (int j = d + d; j <= max; j += d) {
                total -= exactPairs[j];
            }

            exactPairs[d] = total;
        }

        // Prefix sum of pair counts
        long[] prefix = new long[max + 1];
        for (int d = 1; d <= max; d++) {
            prefix[d] = prefix[d - 1] + exactPairs[d];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long k = queries[i] + 1; // queries are 0-indexed

            int l = 1, r = max;
            while (l < r) {
                int mid = (l + r) / 2;
                if (prefix[mid] >= k)
                    r = mid;
                else
                    l = mid + 1;
            }
            ans[i] = l;
        }

        return ans;
    }
}