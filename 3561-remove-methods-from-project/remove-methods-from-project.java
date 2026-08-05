class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
    int m=invocations.length;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int u=invocations[i][0];
            int v=invocations[i][1];
            adj.get(u).add(v);
        }
     Queue<Integer> q=new LinkedList<>();
     boolean[] fault=new boolean[n];
      boolean vis[]=new boolean[n];
     q.add(k);
     fault[k]=true;
     while(!q.isEmpty()){
        int curr=q.remove();
        
        
        if(adj.get(curr).size()>0){
        for(int i=0;i<adj.get(curr).size();i++){
            if(!vis[adj.get(curr).get(i)]){
                q.add(adj.get(curr).get(i)) ;
                vis[adj.get(curr).get(i)]=true;
                fault[adj.get(curr).get(i)]=true;
            } 
        }
        }
     }
     for(int i=0;i<m;i++){
        if(!fault[invocations[i][0]]&&fault[invocations[i][1]]){
        List<Integer> ans=new ArrayList<>();
        for(int j=0;j<n;j++){
            ans.add(j);
        }
        return ans;
        }
     }
       List<Integer> ans=new ArrayList<>();
    for(int i=0;i<n;i++){
       if(!fault[i]){
        ans.add(i);
       }
    }
    return ans;
    }
}