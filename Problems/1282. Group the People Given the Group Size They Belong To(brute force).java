class Solution {
    private int[] counter = new int[501];
    
    public List<List<Integer>> groupThePeople(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        
        for(int i = 0; i < len; i++){
            boolean find = false;
            
            for(int j = 0; j < res.size(); j++){
                if(nums[res.get(j).get(0)] == nums[i] && res.get(j).size() < nums[i]){
                    res.get(j).add(i);
                    find = true;
                    break;
                }
            }
            
            if(!find){
                List<Integer> temp  =  new ArrayList<>();
                temp.add(i);
                res.add(temp);
            }
        }
        
        
        return res;
    }
}
