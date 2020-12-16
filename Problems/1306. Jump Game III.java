class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        
        return canReach(arr, start, visited);
    }
    
    private boolean canReach(int[] arr, int start, boolean[] visited){
        if(start < 0 || start >= arr.length){
            return false;
        }
        else if(arr[start] == 0){
            return true;
        }
        else if(visited[start]){
            return false;
        }
        
         visited[start] = true;
         return canReach(arr, start-arr[start], visited) || canReach(arr, start+arr[start], visited);
    }
}
