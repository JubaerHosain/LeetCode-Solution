class Solution {
    class myCmp implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            if(a[1] != b[1]) {
                return a[1]-b[1];
            } else {
                return b[0]-a[0];
            }
        }
        
    }
    
    public int[] frequencySort(int[] nums) {
        int[] count = new int[201];
        for(int num: nums) {
            count[num+100]++;
        }
        
        Queue<int[]> pq = new PriorityQueue<>(new myCmp());
        for(int i = 0; i < count.length; i++) {
            if(count[i] > 0) {
                pq.add(new int[]{i-100, count[i]});
            }
        }
        
        int index = 0;
        while(!pq.isEmpty()) {
            int[] tmp = pq.poll();
            while(tmp[1] > 0){
                nums[index++] = tmp[0];
                tmp[1]--;
            }
        }
        
        return nums;
    }
}
