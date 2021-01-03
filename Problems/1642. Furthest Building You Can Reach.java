class Solution {
    static class myCmp implements Comparator<Integer>{
        @Override
        public int compare(Integer a, Integer b){
            return b-a;
        }
    }
    
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int index = 0;
        Queue<Integer> pq = new PriorityQueue<>(new myCmp());
        
        for(index = 0; index < heights.length-1; index++) {
            if(heights[index] >= heights[index+1]){
                continue;
            } 
            
            int diff = heights[index+1] - heights[index];
            if(bricks >= diff){
                bricks -= diff;
                pq.add(diff);
            } else if(ladders > 0) {
                if(!pq.isEmpty()){
                    int maxDiff = pq.peek();
                    if(maxDiff > diff){
                        bricks += maxDiff;
                        pq.poll();
                        pq.add(diff);
                        bricks -= diff;
                    }
                }
                ladders--;
            } else {
                break;
            }
        }
        
        return index;
    }
}
