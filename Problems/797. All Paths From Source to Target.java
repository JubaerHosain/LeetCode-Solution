class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        
        List<Integer> path = new ArrayList<>();
        getPath(graph, 0, list, path);
        
        return list;
    }
    
    private void getPath(int[][] graph, int u, List<List<Integer>> list, List<Integer> path){
        path.add(u);
        if(u == graph.length-1){
            list.add(new ArrayList(path));
        }
        else{
            for(int v: graph[u]){
                getPath(graph, v, list, path);
            }
        }
        
        path.remove(path.size()-1);
    }
}
