class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        int ans[]=new int[n];
        int[] copyarr=arr.clone();
          Arrays.sort(copyarr);
          int rank=1;
         HashMap<Integer,Integer> store=new HashMap<>();
         for(int i=0;i<n;i++){
            if(!store.containsKey(copyarr[i])){
 store.put(copyarr[i],rank);
 rank++;
            }
           
         }
      
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(!map.containsKey(arr[i])){
              int key=arr[i];
              int val=store.get(key);
              ans[i]=val;
              map.put(key,val);
            }else{
                ans[i]=map.get(arr[i]);
            }
        }
        return ans;
    }
}