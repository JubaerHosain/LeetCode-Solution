class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length() < k){
            return false;
        }
        
        int[] cnt = new int[26];
        for(int i = 0; i < s.length(); i++){
            cnt[s.charAt(i)-97]++;
        }
        
        int odd = 0;
        for(int i = 0; i < 26; i++){
            if((cnt[i]&1) == 1){
                odd++;
            }
        }
        
        return (odd>k) ? false:true;
    }
}
