class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        HashSet<Integer> set= new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
set.add(nums[i]^nums[j]);
            }
        }
        HashSet<Integer> s=new HashSet<>();
        for(int e:set){
         for(int num:nums){
            s.add(e^num);
         }
        }
        return s.size();
    }
}