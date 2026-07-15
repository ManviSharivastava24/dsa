class Solution {
    public int singleNonDuplicate(int[] nums) {
    int n = nums.length;

    // Edge cases
    if (n == 1) return nums[0];
    if (nums[0] != nums[1]) return nums[0];
    if (nums[n - 1] != nums[n - 2]) return nums[n - 1];

    int l = 1, r = n - 2;

    while (l <= r) {
        int mid = l + (r - l) / 2;

        // Found the single element
        if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
            return nums[mid];
        }

        // Decide which half to search//repeated elements ki first occurnace even position pr honi chahiye ideally
        //agar nahi hai to hum us hisab  se move karege
        
        if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) ||
            (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {
            l = mid + 1;  // single element is on the right
        } else {
            r = mid - 1;  // single element is on the left
        }
    }

    return nums[l];
}

}