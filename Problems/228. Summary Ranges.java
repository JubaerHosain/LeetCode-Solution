class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        
        if(nums.length == 0){
            return result;
        }
        else if(nums.length == 1){
            result.add(nums[0]+"");
            return result;
        }
        
        int start = nums[0], end, i;
        for(i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]+1){
                continue;
            }
            else{
                end = nums[i-1];
                
                if(start != end){
                    result.add(start+"->"+end);
                }
                else{
                    result.add(start+"");
                }
                start = nums[i];
            }
        }
        
        end = nums[i-1];
        if(start != end){
            result.add(start+"->"+end);
        }
        else{
            result.add(start+"");
        }
        
        return result;
    }
}
