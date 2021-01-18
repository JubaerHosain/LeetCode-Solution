class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++) {
            dp1[i] = dp2[i] = 1;
        } 
        
        //lis
        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp1[i] = Math.max(dp1[i], 1+dp1[j]);
                }
            }
        }
        
        //lis(reverse)
        for(int i = nums.length-2; i >= 0; i--) {
            for(int j = nums.length-1; j > i; j--) {
                if(nums[i] > nums[j]) {
                    dp2[i] = Math.max(dp2[i], 1+dp2[j]);
                }
            }
        }
                
        //maximum mountain
        int max = 0;
        for(int i = 1; i < nums.length-1; i++) {  //0 and n-1 th index can't make mountain
            if(hasLeft(nums, i) && hasRight(nums, i)) {
                max = Math.max(max, dp1[i]+dp2[i]-1);
            }
        }
        
        return nums.length-max;
    }
    
    //is there any small element in left of this index
    private boolean hasLeft(int[] nums, int top) {
        for(int i = 0; i < top; i++) {
            if(nums[i] < nums[top]) {
                return true;
            }
        }
        
        return false;
    }
    
    //is there any small element in right of this index
    private boolean hasRight(int[] nums, int top) {
        for(int i = top+1; i < nums.length; i++) {
            if(nums[top] > nums[i]) {
                return true;
            }
        }
        
        return false;
    }
}
