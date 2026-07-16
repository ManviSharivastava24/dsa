class Solution {
    public long gcdSum(int[] nums) {
        int n=nums.length;
        int premax[]=new int[n];
        premax[0]=nums[0];
        for(int i=1;i<n;i++){
            premax[i]=Math.max(premax[i-1],nums[i]);
        }
        int prefixgcd[]=new int[n];
        for(int i=0;i<n;i++){
            prefixgcd[i]=gcd(premax[i],nums[i]);
        }
        Arrays.sort(prefixgcd);
        long sum=0;
        int l=0;
        int r=prefixgcd.length-1;
        while(l<r){
            sum+=(gcd(prefixgcd[l],prefixgcd[r]));
            l++;
            r--;
        }
        return sum;
    }
    public int gcd(int a ,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}