class Solution {
    private HashMap<String, String> getMap(){
        HashMap<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        
        return map;
    }
    
    public List<String> letterCombinations(String digits) {
        HashMap<String, String> map = getMap();
        List<String> result = new ArrayList<>();
        if(digits.length() == 0){
            return result;
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.offer("");
        for(int i = 0; i < digits.length(); i++){
            String letters = map.get(digits.substring(i, i+1)); 
            
            int size = queue.size();
            while(size-- > 0){
                String prev = queue.poll();
                for(int j = 0; j < letters.length(); j++){
                     queue.offer(prev+letters.substring(j, j+1));
                }
            }
        }
        
        while(!queue.isEmpty()){
            result.add(queue.poll());
        }
        
        return result;
    }
}
