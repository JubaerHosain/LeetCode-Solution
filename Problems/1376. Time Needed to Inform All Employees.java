class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] time) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for(int v = 0; v < manager.length; v++) {
            int u = manager[v];
            if(!adj.containsKey(u)) {
                adj.put(u, new ArrayList<>());
            }
            adj.get(u).add(v);
        }
        
        return dfs(headID, time, adj);
    }
    
    //**********************************
    private int dfs(int u, int[] time, Map<Integer, List<Integer>> adj) {
        int max = 0;
        
        if(!adj.containsKey(u)) return 0;

        List<Integer> subs = adj.get(u);
        for(int v: subs) {
            max = Math.max(max, dfs(v, time, adj));
        }
        
        return max+time[u];
    }
}
