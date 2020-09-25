class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length <= 1){
            return 0;
        }
        
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0]-b[0];
            }
        });
        
        int[] cur = intervals[0];
        int res = 0;
        for(int i = 1; i < intervals.length; i++){
            int[] next = intervals[i];
            //System.out.println(next[0] + " " + next[1]);
            
            if(next[0] < cur[1]){
                res++;
                if(next[1] < cur[1]){
                    cur = next;
                }
            }
            else{
                cur = next;
            }
        }
               
        return res;     
    }
}
