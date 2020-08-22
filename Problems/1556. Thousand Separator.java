class Solution {
    public String thousandSeparator(int n) {
        String s = Integer.toString(n), result = "";
        
        
        if(s.length() > 3){
            int len = s.length();
            
            while(len > 3){
                int i = len-3;
                String left = s.substring(0,i);
                String right = s.substring(i, s.length());
                s = left + "." + right;
                len -= 3;
            }
            
            return s;
        }
        else{
            return s;
        }
    }
}
