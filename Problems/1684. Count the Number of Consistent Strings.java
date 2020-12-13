class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] contains = new boolean[26];
        for(int i = 0; i < allowed.length(); i++){
            contains[allowed.charAt(i)-'a'] = true;
        }
        
        int consistent = 0;
        for(String str: words){
            if(isConsistentWord(str, contains)){
                consistent++;
            }
        }
        
        return consistent;
    }
    
    private boolean isConsistentWord(String str, boolean[] contains){
        for(int i = 0; i < str.length(); i++){
            if(!contains[str.charAt(i)-'a']){
                return false;
            }
        }
        
        return true;
    }
}
