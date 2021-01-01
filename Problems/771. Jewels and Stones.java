class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < stones.length(); i++){
            char c = stones.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }
        
        int count = 0;
        for(int i = 0; i < jewels.length(); i++){
            char c = jewels.charAt(i);
            if(map.containsKey(c)){
                count += map.get(c);
            }
        }
        
        return count;
    }
}
