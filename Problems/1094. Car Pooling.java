class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, new Comparator<int[]>(){
            public int compare(int[] i1, int[] i2) {
                 return i1[1] - i2[1];
            }
        });
        
        Queue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] t1, int[] t2) {
                return t1[2] - t2[2];
            }
        });
        
        int curr = 0;
        for(int i = 0; i < trips.length; i++){
            while(!pq.isEmpty() && pq.peek()[2] <= trips[i][1]){
                curr -= pq.poll()[0];
            }
            
            curr += trips[i][0];
            pq.offer(trips[i]);
            if(curr > capacity){
                return false;
            }
        }
        
        return true;
    }
}
