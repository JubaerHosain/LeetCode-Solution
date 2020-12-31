class Solution {
    public int[] decompressRLElist(int[] nums) {
        int freqCount = 0;
        for(int i = 0; i < nums.length; i += 2){
            freqCount += nums[i];
        }
        
        int[] result = new int[freqCount];
        int index = 0;
        for(int i = 0; i < nums.length; i += 2){
            for(int j = 0; j < nums[i]; j++){
                result[index++] = nums[i+1];
            }
        }
        
        return result;
    }
}
