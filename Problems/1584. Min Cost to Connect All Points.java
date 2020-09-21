class Solution {
    class Node{
        int u, v, w;

        public Node(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    class myComparator implements Comparator<Node> { 
        public int compare(Node o1, Node  o2) 
        { 
            if(o1.w < o2.w){
                return -1;
            }
            else if(o1.w > o2.w){
                return 1;
            }
            else{
                return 0;
            }
        } 
    } 
    
    int Kruskals(int n, PriorityQueue<Node> pq){
        int parent[] = new int[n];
        for(int i = 0; i < n; i++) parent[i] = -1;

        int weight = 0;
        while(!pq.isEmpty()){
            Node edge = pq.poll();

            int u = find(parent, edge.u);
            int v = find(parent, edge.v);

            if(u != v){
                weight += edge.w;
                union(parent, u, v);
            }
        }

        return weight;
    }
    
    int find(int parent[], int key){
        if(parent[key] == -1){
            return key;
        }
            
        return find(parent, parent[key]);
    }

    void union(int parent[], int x, int y){
        int xset = find(parent, x);
        int yset = find(parent, y);
            
        parent[xset] = yset;
    }

    
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>(5, new myComparator());

        for(int i = 0; i < points.length; i++){
            for(int j = i + 1; j < points.length; j++){
                pq.add(new Node(i, j, Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1])));
            }
        }
        
        return Kruskals(points.length, pq);
    }
}
