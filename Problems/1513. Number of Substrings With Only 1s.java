class Solution {
    private long getSum(long n){
        return (n*(n+1))/2;
    }
    
    public int numSub(String s) {
        long result = 0, sublen= 0;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                sublen = 0;
                continue;
            }
            else{
                while(i < s.length() && s.charAt(i) != '0'){
                   sublen++;
                   i++;
                }
                i--;
                    
                result = (result+getSum(sublen))%1000000007;
            }
        }
        
        return (int)result;
    }
}
