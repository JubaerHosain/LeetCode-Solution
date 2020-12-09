class Solution {
    private static enum Color{
        WHITE, GRAY, BLACK;
    }
    
    public int[] findOrder(int numCourses, int[][] edges) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        Color[] color = new Color[numCourses];
        
        for(int i = 0; i < numCourses; i++){
            adj[i] = new ArrayList<>();
            color[i] = Color.WHITE;
        }
        
        //Make adjacency list
        for(int i = 0; i < edges.length; i++){
            adj[edges[i][1]].add(edges[i][0]);
        }
        
        Stack<Integer> stack = new Stack<>();
        //Decting cycle & running dfs as well
        for(int u = 0; u < numCourses; u++){
            if(color[u] == Color.WHITE){
                if(hasCycle(adj, color, u, stack)){
                    return new int[0];
                }
            }
        }
        
        int res[] = new int[numCourses];
        int i = 0;
        while(!stack.empty()){
            res[i] = stack.pop();
            i++;
        }
        
        return res;
    }
    
    private boolean hasCycle(ArrayList<Integer>[] adj, Color[] color, int u, Stack<Integer> stack){
        color[u] = Color.GRAY;
        
        for(Integer v: adj[u]){
            if(color[v] == Color.WHITE){
                if(hasCycle(adj, color, v, stack)){
                    return true;
                }
            }
            else if(color[v] == Color.GRAY){
                return true;
            }
        }
        
        color[u] = Color.BLACK;
        stack.push(u);
        
        return false;
    }
}
