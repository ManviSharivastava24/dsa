class Solution {
    public long sumAndMultiply(int n) {
         String s=Integer.toString(n);
         long sum=0;
         StringBuilder sb=new StringBuilder();
         for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='0'){
                sb.append(s.charAt(i));
                sum+=(s.charAt(i)-'0');
            }
         }
         if(sb.length()==0){
            return 0;
         }
        int num=Integer.parseInt(sb.toString());
        long ans=sum*num;
        return ans;

    }
}