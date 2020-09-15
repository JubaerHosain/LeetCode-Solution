class Solution {
    public List<Integer> partitionLabels(String S) {
        HashMap<Character, ArrayList<Integer>> map = new HashMap<Character, ArrayList<Integer>>();
        List<Integer> res = new ArrayList<Integer>();
        int len = S.length();
        
        for(int i = 0; i < len; i++){
            if(!map.containsKey(S.charAt(i))){
                map.put(S.charAt(i), new ArrayList<Integer>());
            }
            
            map.get(S.charAt(i)).add(i);
        }
        
        int start = 0, max = 0;
        for(int i = 0; i < len; i++){
            int l = map.get(S.charAt(i)).size();
            
            max = Math.max(max, map.get(S.charAt(i)).get(l-1));
            if(i == max){
                res.add(max-start+1);
                start = i+1;
                max = 0;
            }
        }
            
        return res;
    }
}
