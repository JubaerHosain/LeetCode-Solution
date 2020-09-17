class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length%k != 0){
            return false;
        }
        
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 0);
            }
            
            map.put(nums[i], map.get(nums[i])+1);
        }
        
        while(map.size() > 0){
            int curr = map.firstKey();
            
            for(int val = curr; val < curr+k; val++){
                if(!map.containsKey(val)){
                    return false;
                }
                else{
                    map.put(val, map.get(val)-1);
                    
                    if(map.get(val) == 0){
                        map.remove(val);
                    } 
                }
            }
        }
        
        return true;
    }
}
