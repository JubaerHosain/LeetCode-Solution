class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++){
            list.add(index[i], nums[i]);
        }
        
        int i = 0;
        int[] result = new int[list.size()];
        for(int val: list){
            result[i++] = val;
        }
        
        return result;
    }
}
