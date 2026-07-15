class Solution {
    public int gcdOfOddEvenSums(int n) {
        int N=2*n;
        int oddsum=0;
        int evensum=0;
           

           for (int i=1;i<=N;i++){
            if(i%2==0){
                evensum+=i;
            }else{
              oddsum+=i;
            }
           }
           return gcd(oddsum,evensum);
    }
    public int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}