class Solution {
    private int max = 10000;
    
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[max+1];
        
        for(int i = 0; i < nums.length; i++){
            count[nums[i]] += nums[i];
        }
        
        for(int i =  1; i < max; i++){
            count[i+1] = Math.max(count[i+1]+count[i-1], count[i]);
        }
        
        
        
        return count[max-1];
    }
}
