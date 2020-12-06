class Solution {
    class Node{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int time = 0, fresh = 0;
        
        int[][] dir = {{0,1}, {1,0}, {0,-1},{-1,0}};
        
        Queue<Node> queue = new LinkedList<>();
        for(int x = 0; x < row; x++){
            for(int y = 0; y < col; y++){
                if(grid[x][y] == 1){
                    fresh++;
                }
                
                if(grid[x][y] == 2){
                    queue.add(new Node(x, y));
                }
            }
        }
        
        if(fresh == 0){
            return 0;
        }
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            while(size-- > 0){
                Node u = queue.poll();
                
                for(int i = 0; i < 4; i++){
                    Node v = new Node(u.x+dir[i][0], u.y+dir[i][1]);
                    
                    if((v.x >= 0 && v.x < row) && (v.y >= 0 && v.y < col)){
                        if(grid[v.x][v.y] == 1){
                            queue.add(new Node(v.x, v.y));
                            grid[v.x][v.y] = 2;
                            fresh--;
                        }
                    }
                }
            }
            
            time++;
            if(fresh == 0){
                return time;
            }
        }
        
        return -1;
    }
}
