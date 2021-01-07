class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int key: arr) {
            map.put(key, map.getOrDefault(key,0)+1);
        }
        
        int index = 0;
        int[] count = new int[map.size()];
        for(Map.Entry<Integer, Integer> obj: map.entrySet()) {
            count[index++] = obj.getValue();
        }
        
        index = 0;
        int sum = 0;
        Arrays.sort(count);
        for(; index < count.length; index++) {
            sum += count[index];
            if(sum >= k) {
                break;
            }
        }
        
        return (sum == k) ? count.length-index-1:count.length-index;
    }
}
