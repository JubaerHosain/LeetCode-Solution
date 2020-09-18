class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int a: A){
            pq.offer(a);
        }
        
        while(K-- > 0){
            int a = pq.poll();
            pq.offer(-a);
        }
        
        int sum = 0;
        while(!pq.isEmpty()){
            sum += pq.poll();
        }
        
        return sum;
    }
}
