class Solution {
    public int minDeletions(String s) {
        int[] count = new int[26];
        for(char ch: s.toCharArray()) {
            count[ch-'a']++;
        }
        
        Arrays.sort(count);
        int keep = count[25], prev = count[25];
        for(int i = 24; i >= 0; i--) {
            if(count[i] == 0 || prev == 0) {
                break;
            } 
            
            prev = Math.min(prev-1, count[i]);
            keep += prev;            
        }
        
        return s.length()-keep;
    }
}
