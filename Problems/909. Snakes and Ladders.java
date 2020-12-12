class Solution {    
    public int snakesAndLadders(int[][] board) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = board.length;
        int count = n*n;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if((n-i)%2 == 0){
                    map.put(count, board[i][j]);
                }
                else{
                    map.put(count, board[i][n-j-1]);
                }
                count--;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        boolean[] visited = new boolean[n*n+1];
        visited[1] = true;
        
        int step = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            
            while(size-- > 0){
                int curr = queue.poll();
            
                if(curr ==  n*n){
                    return step;
                }
            
                for(int k = 1; k <= 6; k++){
                    
                    if(curr+k > n*n){
                        break;
                    }
                    else if(visited[curr+k]){
                        continue;
                    }   
                
                    visited[curr+k] = true;
                    if(map.get(curr+k) == -1){
                        queue.offer(curr+k);
                    }
                    else{
                        queue.offer(map.get(curr+k));
                    }
                }
            }
            
            step++;
        }
        
        return -1;
    }
}
