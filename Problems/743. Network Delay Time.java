class Solution {
    class Node{
        int node, weight;
        
        public Node(int n, int w){
            this.node = n;
            this.weight = w;
        }
    }
    
    public int networkDelayTime(int[][] times, int N, int K) {
        ArrayList<Node>[] list = new ArrayList[N+1];
        int[] dist = new int[N+1];
        
        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<Node>();
            dist[i] = Integer.MAX_VALUE;
        }
        
        //Making adjList
        for(int i = 0; i < times.length; i++){
            list[times[i][0]].add(new Node(times[i][1], times[i][2]));
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(K, 0));
        dist[K] = 0;
        
        while(!queue.isEmpty()){
            Node u = queue.poll();
            
            for(Node v: list[u.node]){
                Node tmp = new Node(v.node, u.weight + v.weight);
                
                if(dist[v.node] > tmp.weight){
                    queue.offer(tmp);
                    dist[v.node] = tmp.weight;
                }
            }
        }
        
        int max = 0;
        for(int i = 1; i <= N; i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            
            max = Math.max(dist[i], max);
        }
        
        return max;
    }
}
