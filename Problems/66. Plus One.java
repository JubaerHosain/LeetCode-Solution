class Solution {
    public int[] plusOne(int[] digits) {
        int add = 1;
        for(int i = digits.length-1; i >= 0; i--){
            add = digits[i] + add;
            digits[i] = add%10;
            add = add/10;
        }
        
        //for 99999 case
        if(add != 0){
            int[] result = new int[digits.length+1];
            result[0] = add;
            for(int i = 1; i < result.length; i++){
                result[i] = digits[i-1];
            }
            
            return result;
        }
        
        return digits;
    }
}
