class Solution {
    public int jump(int[] nums) {
        int len = nums.length, pos = 0, des = 0, jump = 0;
        
        for(int i = 0; i < len-1; i++){
            des = Math.max(des, i+nums[i]);
            
            if(pos == i){
                jump++;
                pos = des;
            }
        }
        
        return jump;
    }
}
