class Solution {
    public double BFS(int n, int src, int dest, HashMap<Integer, Double> adj[]){
        Queue<Integer> queue = new LinkedList<Integer>();
        double[] Prob = new double[n];
           
        queue.add(src);
        Prob[src] = 1.0;
        
        while(!queue.isEmpty()){
            int u = queue.poll();
            
            for(Map.Entry<Integer, Double> entry: adj[u].entrySet()){
                int v = entry.getKey();
                double pro = entry.getValue();
                
                //one node may be pushed more than once in the queue   
                if((Prob[u] * pro) > Prob[v]){
                    Prob[v] = Prob[u] * pro;
                    queue.add(v);
                }
            }
        }
        
        return  Prob[dest]; 
    }
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        HashMap<Integer, Double> adj[] = new HashMap[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new HashMap<>();
        }
        
        for(int i = 0; i < edges.length; i++){
            adj[edges[i][0]].put(edges[i][1], succProb[i]);
            adj[edges[i][1]].put(edges[i][0], succProb[i]);
        }
        
        return BFS(n, start, end, adj);
    }
}
