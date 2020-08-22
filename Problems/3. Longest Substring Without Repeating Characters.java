class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Set<Character> set = new HashSet<>();
        int a = 0, b = 0;
        
        while(b < s.length()){
            if(!set.contains(s.charAt(b))){
                set.add(s.charAt(b));
                max = Math.max(max, set.size());
                b++;
            }
            else{
                set.remove(s.charAt(a));
                a++;
            }
        }
        
        return max;
    }
}
