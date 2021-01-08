class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        if(barcodes.length == 1) {
            return barcodes;
        }
        
        int[] freq = new int[10001];
        for(int code: barcodes) {
            freq[code]++;
        }
        
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> (b[1]-a[1]));
        for(int i = 1; i <= 10000; i++) {
            if(freq[i] > 0) {
                pq.add(new int[]{i, freq[i]});
            }
        }
        
        int index = 0;
        while(pq.size() > 1) {
            int[] a = pq.poll();
            int[] b = pq.poll();
            
            barcodes[index++] = a[0];
            barcodes[index++] = b[0];
            a[1]--; b[1]--;
            
            if(a[1] > 0) {
                pq.add(new int[]{a[0], a[1]});
            }
            if(b[1] > 0) {
                pq.add(new int[]{b[0], b[1]});
            }
        }
        
        if(!pq.isEmpty()) {
            int[] a = pq.poll();
            barcodes[index] = a[0];
        }
        
        return barcodes;
    }
}
