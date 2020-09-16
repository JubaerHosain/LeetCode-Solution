class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < stones.length; i++){
            pq.offer(stones[i]);
        }
        
        int first = 0, second = 0;
        while(pq.size() > 1){
            first = pq.poll();
            second = pq.poll();
            
            if(first-second > 0){
                pq.offer(first-second);
            }
        }
        
        return (pq.size() == 0) ? 0 : pq.poll();
    }
}
