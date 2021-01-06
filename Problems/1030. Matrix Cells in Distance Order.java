class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r, int c) {
        int index = 0;
        int[][] result = new int[R*C][2];
        
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                result[index][0] = i;
                result[index][1] = j;
                index++;
            }
        }
        
        Arrays.sort(result, (a, b)-> 
            (Math.abs(r-a[0])+Math.abs(c-a[1])) - (Math.abs(r-b[0])+Math.abs(c-b[1]))
        );
        
        return result;
    }
}
