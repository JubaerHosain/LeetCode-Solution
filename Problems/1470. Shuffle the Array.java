class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2*n];
        int index = 0, i = 0;
        
        while(index < 2*n){
            res[index] = nums[i];
            res[index+1] = nums[n+i];
            index += 2;
            i++;
        }
        
        return res;
    }
}
