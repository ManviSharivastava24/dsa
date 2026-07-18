class Solution {
    public int findGCD(int[] nums) {
        int n=nums.length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        int a=min;
        int b=max;
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}