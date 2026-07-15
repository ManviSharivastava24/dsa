class Solution {
    public boolean canbeshipped(int[] weights, int days, int mid) {
        int n = weights.length;
        int count = 1;
        int totalweight = 0;
        for (int i = 0; i < n; i++) {
            totalweight += weights[i];
            if (totalweight > mid) {
                count++;
                if (count > days) {
                    return false;
                }
                totalweight = weights[i];
            }
        }
        return true;
    }

    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int l = Integer.MIN_VALUE;
        int r = 0;
        for (int i = 0; i < n; i++) {
            l = Math.max(l, weights[i]);
            r += weights[i];
        }
int ans=-1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (canbeshipped(weights, days, mid)) {
        ans=mid;
         r = mid-1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}