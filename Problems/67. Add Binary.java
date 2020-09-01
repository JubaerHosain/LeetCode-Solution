class Solution {
    public String addBinary(String a, String b) {
        String s = "";
        
        int i = a.length()-1, j = b.length()-1, carry = 0;
        
        while(i >= 0 || j >= 0){
            int sum = carry;
            
            if(i >= 0){
                sum += a.charAt(i)-'0';
                i--;
            }
            if(j >= 0){
                sum += b.charAt(j)-'0';
                j--;
            }
            
            carry = (sum > 1) ? 1 : 0;
            s += (sum%2);
        }
        
        if(carry == 1){
            s += "1";
        }
        
        StringBuilder sb = new StringBuilder(s);
        
        return sb.reverse().toString();
    }
}
