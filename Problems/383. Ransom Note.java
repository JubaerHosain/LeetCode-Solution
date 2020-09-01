class Solution {
    public boolean canConstruct(String r, String m) {
        int[] c1 = new int[26], c2 = new int[26];
        
        for(int i = 0; i < r.length();  i++){
            c1[r.charAt(i)-'a']++;
        }
        
        for(int i = 0; i < m.length();  i++){
            c2[m.charAt(i)-'a']++;
        }
        
        for(int i = 0; i < 26; i++){
            if(c1[i] > c2[i]){
                return false;
            }
        }
        
        return true;
    }
}
