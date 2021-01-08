class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1) {
            return intervals;
        }
        
        Arrays.sort(intervals, (a,b)->
            a[0]==b[0] ? a[1]-b[1]:a[0]-b[0]
        );
        
        List<int[]> list = new ArrayList<>();
        int x = intervals[0][0];
        int y = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= y) {
                y = Math.max(y,intervals[i][1]);
            } else {
                list.add(new int[]{x,y});
                x = intervals[i][0];
                y = intervals[i][1];
            }
        }
        list.add(new int[]{x,y});
        
        int[][] res = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
}
