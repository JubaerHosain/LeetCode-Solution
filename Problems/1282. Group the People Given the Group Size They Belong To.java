class Solution {
    private int[] counter = new int[501];
    
    public List<List<Integer>> groupThePeople(int[] nums) {
        int len = nums.length;
        
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 0; i < len; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new ArrayList<Integer>());
            }
            
            map.get(nums[i]).add(i);
        }
        
        
        List<List<Integer>> res = new ArrayList<>();
        for(Map.Entry<Integer, ArrayList<Integer>> entry: map.entrySet()){
            int key = entry.getKey(), size = entry.getValue().size();
            ArrayList<Integer> list =  entry.getValue();
            
            if(key == size){
                res.add(list);
            }
            else{
                int index = 0;
                
                for(int i = 0; i < size/key; i++){
                    ArrayList<Integer> temp =  new ArrayList<Integer>();
                    
                    for(int j =  0; j < key; j++){
                        temp.add(list.get(index));
                        index++;
                    }
                    res.add(temp);
                }
            }
        }
        
        
        return res;
    }
}
