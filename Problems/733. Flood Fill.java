class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(newColor == image[sr][sc]){
            return image;
        }
        
        int rows = image.length;
        int cols = image[0].length;
        int source = image[sr][sc];
        
        dfs(image, sr, sc, rows, cols, source, newColor);
        
        return image;
    }
    
     private void dfs(int[][] image, int sr, int sc, int rows, int cols, int source, int newColor){
         if(sr < 0 || sr >= rows || sc < 0 || sc >= cols){
             return;
         } else if(image[sr][sc] != source){
             return;
         }
         
         image[sr][sc] = newColor;
        
         dfs(image, sr, sc+1, rows, cols, source, newColor);
         dfs(image, sr, sc-1, rows, cols, source, newColor);
         dfs(image, sr+1, sc, rows, cols, source, newColor);
         dfs(image, sr-1, sc, rows, cols, source, newColor);
             
     }
}
