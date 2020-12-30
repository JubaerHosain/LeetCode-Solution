class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        int[][] dist = makeAdj(n, prerequisites);

        for(int k = 0; k < n; k++){             //Try all intermediate node
            for(int i = 0; i < n; i++){         //Try all possible starting node
                for(int j = 0; j < n; j++){     //Try all possible ending node
                    if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE){
                        dist[i][j] = 1;
                    }
                }
            }
        }
        
        List<Boolean> result = new ArrayList<>();
        for(int i = 0; i < queries.length; i++){
            if(dist[queries[i][0]][queries[i][1]] != Integer.MAX_VALUE){
                result.add(true);
            } else {
                result.add(false);
            }
        }
        
        return result;
    } 
    
    private int[][] makeAdj(int n, int[][] edges){
        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 1;
        }

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            dist[u][v] = 1;
        }

        return dist;
    }
}
