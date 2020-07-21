class Solution {
    private ArrayList[] createTree(int n, int[][] edges){
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < edges.length; i++){
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        
        return adj;
    }
    
    private int[] dfs(int node, ArrayList<Integer>[] adj, boolean[] visited, char[] ch, int[] result){
        visited[node] = true;
        int[] count = new int[26];
        
        for(Integer v: adj[node]){
            if(!visited[v]){
                int[] cnt = dfs(v, adj, visited, ch, result);
                
                for(int  i = 0; i < 26; i++){
                    count[i] += cnt[i];
                }
            }
        }
        
        count[ch[node]-97]++;
        result[node] = count[ch[node]-97];
        
        return count; 
    }
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        ArrayList<Integer>[] adj = createTree(n, edges);
        int[] result = new int[n];
        boolean[] visited = new boolean[n];
        char[] ch = labels.toCharArray();
        
        dfs(0, adj, visited, ch, result);
        
        return result;
    }
    
    
}
