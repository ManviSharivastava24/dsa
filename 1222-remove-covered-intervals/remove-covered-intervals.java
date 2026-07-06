class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        List<int[]> li = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });
        int n = intervals.length;
        int prestart = intervals[0][0];
        int preend = intervals[0][1];
        int i = 1;
        while (i < n) {

            int currstart = intervals[i][0];
            int currend = intervals[i][1];

            if (preend >= currend) {
                i++;

            } else {
                li.add(new int[] { prestart, preend });
                prestart = currstart;
                preend = currend;
                i++;

            }

        }
        return li.size() + 1;
    }
}