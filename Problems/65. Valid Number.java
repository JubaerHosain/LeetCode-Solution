import java.util.regex.*;

class Solution {
    public boolean isNumber(String s) {
        Pattern p = Pattern.compile("[+-]?((\\d+(\\.\\d*)?(e[+-]?\\d+)?)|((\\.\\d+)(e[+-]?\\d+)?))");
        Matcher m  = p.matcher(s.trim());
        
        if(m.matches()){
            return true;
        }
        else{
            return false;
        }
    }
}
