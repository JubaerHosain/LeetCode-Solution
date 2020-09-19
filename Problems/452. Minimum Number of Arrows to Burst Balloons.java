class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length < 1){
            return 0;
        }
        
        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[1]-b[1];
            }
        });
        
        int cnt = 1, end = points[0][1];
        for(int i = 1; i < points.length; i++){
            if(end >= points[i][0]){
                continue;
            }
            else{
                cnt++;
                end = points[i][1];
            }
        }
        
        return cnt;
    }
}
