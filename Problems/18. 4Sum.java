class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 4){
            return result;
        }
        
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-3; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            
            for(int j = i+1; j < nums.length-2; j++){
                
                int k = j+1;
                int l = nums.length-1;
                while(k < l){
                    int sum = nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum ==  target){
                        List<Integer> sol = new ArrayList<>();
                        sol.add(nums[i]);
                        sol.add(nums[j]);
                        sol.add(nums[k]);
                        sol.add(nums[l]);
                        if(!result.contains(sol)){
                            result.add(sol);
                        }
                        
                        k++; l--;
                    }
                    else if(sum < target){
                        k++;
                    }
                    else{
                        l--;
                    }
                }
            }
        }
        
        return result;
    }
}
