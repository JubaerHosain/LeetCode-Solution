class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        int len = arr.length, res = 0, size = 0;
        for(int i = 0; i < len; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i], 0);
            }
            
            map.put(arr[i], map.get(arr[i])+1);
        }
            
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            pq.add(entry.getValue());
        }
          
            
        while(size < len/2){
            size += pq.poll();
            res++;
        }
            
        return res;
    }
}
