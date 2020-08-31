class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        else if(needle.length() > haystack.length() || haystack.length() == 0){
            return -1;
        }
        
        for(int i = 0; i < haystack.length()-needle.length()+1; i++){
            if(haystack.substring(i, i+needle.length()).equals(needle)){
                return i;
            }
        }
        
        return -1;
    }
}
