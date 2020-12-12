class Solution {
    class Node{
        int x, y;
        
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] != 0){
            return -1;
        }
        
        int level = 1, n = grid.length;
        int[][] dir = {{-1,-1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}};
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));
        while(!queue.isEmpty()){
            int size = queue.size();
            
            while(size-- > 0){
                Node curr = queue.poll();
                if(curr.x == n-1 && curr.y == n-1){
                    return level;
                }
                
                for(int d[]: dir){
                    int x = curr.x + d[0];
                    int y = curr.y + d[1];
                        
                    if(x >= 0 && y >= 0 && x < n && y < n && grid[x][y] == 0){
                        grid[x][y] = 1;
                        queue.offer(new Node(x, y));
                    }
                }
            }
            level++;
        }
        
        return -1;
    }
}
