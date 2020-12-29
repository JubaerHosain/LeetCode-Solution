class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = makeAdj(n, edges);
        
        for(int k = 0; k < n; k++){             //Try all intermediate node
            for(int i = 0; i < n; i++){         //Try all possible starting node
                for(int j = 0; j < n; j++){     //Try all possible ending node
                    if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE
                      && dist[i][j] > dist[i][k]+dist[k][j]){
                        dist[i][j] = dist[j][i] = dist[i][k]+dist[k][j];
                    }
                }
            }
        }
        
        int minCount = Integer.MAX_VALUE;
        int city = -1;
        for(int u = 0; u < n; u++){
            int count = 0;
            for(int v = 0; v < n; v++){
                if(dist[u][v] <= distanceThreshold){
                    count++;
                }
            }
            
            if(count <= minCount){
                city = u;
                minCount = count;
            }
        }
        
        return city;
    }
    
    private int[][] makeAdj(int n, int[][] edges){
        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            
            dist[u][v] = w;
            dist[v][u] = w;
        }
        
        return dist;
    }
}
