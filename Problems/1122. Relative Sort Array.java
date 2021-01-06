class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] freq = new int[1001];
        int[] result = new int[arr1.length];
        
        for(int val: arr1){
            freq[val]++;
        }
        
        int index = 0;
        for(int val: arr2){
            while(freq[val] > 0){
                result[index++] = val;
                freq[val]--;
            }
        }
        
        for(int i = 0; i < freq.length; i++){
            while(freq[i] > 0){
                result[index++] = i;
                freq[i]--;
            }
        }
        
        return result;
    }
}
