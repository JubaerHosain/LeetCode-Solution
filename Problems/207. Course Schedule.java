class Solution {
    private static enum Color{
        WHITE, GRAY, BLACK;
    }
    
    public boolean canFinish(int numCourses, int[][] edges) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        Color[] color = new Color[numCourses];
        
        for(int i = 0; i < numCourses; i++){
            adj[i] = new ArrayList<>();
            color[i] = Color.WHITE;
        }
        
        //Make adjacency list
        for(int i = 0; i < edges.length; i++){
            adj[edges[i][0]].add(edges[i][1]);
        }
        
        for(int u = 0; u < numCourses; u++){
            if(color[u] == Color.WHITE){
                if(hasCycle(adj, color, u)){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean hasCycle(ArrayList<Integer>[] adj, Color[] color, int u){
        color[u] = Color.GRAY;
        
        for(Integer v: adj[u]){
            if(color[v] == Color.WHITE){
                if(hasCycle(adj, color, v)){
                    return true;
                }
            }
            else if(color[v] == Color.GRAY){
                return true;
            }
        }
        
        color[u] = Color.BLACK;
        
        return false;
    }
}
