class Solution {
    class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int shortestBridge(int[][] A) {
        int count = 0;
        List<Node> a = new ArrayList<>();
        List<Node> b = new ArrayList<>();
        
        for(int x = 0; x < A.length; x++){
            for(int y = 0; y < A[0].length; y++){
                if(A[x][y] == 1){
                    count++;
                    
                    if(count == 1){
                        dfs(A, x, y, a);
                    }
                    else if(count == 2){
                        dfs(A, x, y, b);
                    }
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < a.size(); i++){
            for(int j = 0; j < b.size(); j++){
                int dist = Math.abs(a.get(i).x - b.get(j).x) + Math.abs(a.get(i).y - b.get(j).y) -1;
                min = Math.min(min, dist);
            }
        }
        
        return min;
    }
    
    private void dfs(int[][] A, int x, int y, List<Node> list){
        if(x < 0 || y < 0 || x >= A.length || y >= A[0].length || A[x][y] == 0){
            return;
        }
        A[x][y] = 0;
        list.add(new Node(x, y));
        
        dfs(A, x+1, y, list);
        dfs(A, x-1, y, list);
        dfs(A, x, y+1, list);
        dfs(A, x, y-1, list);
    }
}
















