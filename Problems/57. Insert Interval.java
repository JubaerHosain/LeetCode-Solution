class Solution {
    public int[][] insert(int[][] intervals, int[] newIn) {
        List<int[]> list = new ArrayList<>();
        for(int[] curr: intervals) {
            if(curr[1] < newIn[0]) {
                list.add(curr);
            } else if(newIn[1] < curr[0]) {
                list.add(newIn);
                newIn = curr;
            } else {
                newIn[0] = Math.min(curr[0], newIn[0]);
                newIn[1] = Math.max(curr[1], newIn[1]);
            }
        }
        list.add(newIn);
        
        return list.toArray(new int[list.size()][]);
    }
}
