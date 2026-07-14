class Solution {
    public boolean search(int[] nums, int target) {
        int n=nums.length;
        int l=0;
        int r=nums.length-1;
        while(l<=r){
           int mid=(l+r)/2;
           if(nums[mid]==target){
            return true;
           }
          if(nums[l] == nums[mid] && nums[mid] == nums[r]){
    l++;
    r--;
    continue;
}
           if(nums[mid]>=nums[l]){
            if(nums[mid]>target&&target>=nums[l]){
                r=mid-1;
            }else{
                l=mid+1;
            }
           }else{
            if(nums[mid]<target&&target<=nums[r]){
                l=mid+1;
            }else{
                r=mid-1;
            }
           }
        }
        return false;
    }
}