class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length-1;
        int index = nums.length-1;
        
        int[] result = new int[right+1];
        while(index >= 0) {
            if(Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[index--] = nums[left]*nums[left];
                left++;
            } else {
                result[index--] = nums[right]*nums[right];
                right--;
            }
        }
        
        return result;
    }
}
