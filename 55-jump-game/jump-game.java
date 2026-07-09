class Solution {
    public boolean canJump(int[] nums) {
        int reach = 0;  // farthest we can go
        for (int i = 0; i < nums.length; i++) {
            if (i > reach) return false;  // stuck before reaching i
            reach = Math.max(reach, i + nums[i]);
        }
        return reach>=nums.length-1;
    }
}
