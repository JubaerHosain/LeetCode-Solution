class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        
        if(strs.length == 0){
            return res;
        }
        else if(strs.length == 1){
            return strs[0];
        }
        
        int index = 0;
        boolean find = true;
        char match = '0';
        while(find){
            if(index < strs[0].length()){
               match = strs[0].charAt(index); 
            }
            else{
                break;
            }
            for(int i = 1; i < strs.length; i++){
                String str = strs[i];
                
                if(index < str.length() && str.charAt(index) == match){
                   continue; 
                }
                else{
                    find = false;
                    break;
                }
            }
            
            index++;
            if(find){
                res += match; 
            }
        }
        
        return res;
    }
}
