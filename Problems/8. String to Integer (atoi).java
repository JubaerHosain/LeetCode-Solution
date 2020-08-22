import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public int myAtoi(String str) {
        Pattern p = Pattern.compile("(^[+-]?\\d+)([\\s+-.\\w]*)");
        Matcher m = p.matcher(str.trim());
        
        if(m.find()){
            str = m.group(1);
            
            boolean positive = true;
            if(str.startsWith("-")){
                positive = false;
            }
            
            try{
                int num = Integer.parseInt(str);
                return num;
            }catch(Exception e){
                if(positive){
                    return Integer.MAX_VALUE;
                }
                else{
                    return Integer.MIN_VALUE;
                }
            }
                
        }
        
        return 0;
    }
}
