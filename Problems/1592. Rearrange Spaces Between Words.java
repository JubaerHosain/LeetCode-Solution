class Solution {
    public String reorderSpaces(String text) {
        String[] words = text.trim().split("\\s+");
        int spaceCnt = 0, wordLen = words.length;
        for(int i = 0; i < text.length(); i++){
            if(text.charAt(i) == ' ') spaceCnt++;
        }
        
        String res = words[0];
        if(wordLen == 1){
            for(int i = 0; i < spaceCnt; i++){
                res += " ";
            }
            
            return res;
        }
        
        int middle = spaceCnt/(wordLen-1), end = spaceCnt%(wordLen-1); 
        for(int i = 1; i < wordLen; i++){
            String sp = "";
            for(int j = 0; j < middle; j++){
                sp += " ";
            }
            
            res += (sp+words[i]);
        }
        
        for(int i = 0; i < end; i++){
                res += " ";
        }
        
        
        return res;
    }
}
