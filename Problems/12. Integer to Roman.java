class Solution {
    public String intToRoman(int num) {
        int[] number = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        
        String res = "";
        int i = 0;
        
        while(num > 0){
            if(num >= number[i]){
                num -= number[i];
                res += roman[i];
            }
            
            if(num < number[i]){
                i++;
            }
        }
        
        return res;
    }
}
