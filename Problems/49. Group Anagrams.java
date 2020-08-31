class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, ArrayList<String>> map = new HashMap<HashMap<Character, Integer>, ArrayList<String>>();
        
        for(String str: strs){
            HashMap<Character, Integer> key = new HashMap<Character, Integer>();
            
            for(int i = 0; i < str.length(); i++){
                if(key.containsKey(str.charAt(i))){
                    key.put(str.charAt(i), key.get(str.charAt(i))+1);
                }
                else{
                    key.put(str.charAt(i), 1);
                }
            }
            
            if(map.containsKey(key)){
                map.get(key).add(str);
            }
            else{
                ArrayList<String> tmp = new ArrayList<>();
                tmp.add(str);
                map.put(key, tmp);
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        for(HashMap<Character, Integer> entry: map.keySet()){
            result.add(map.get(entry));
        }
        
        return result;
    }
}
