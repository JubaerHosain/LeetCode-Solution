class Solution {
    public int hIndex(int[] nums) {
        int n = nums.length;
        int left = 0, right = n-1;

        Arrays.sort(nums);
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == n-mid){
                return nums[mid];
            } else if(nums[mid] > n-mid){
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return n-left;
    }
}
