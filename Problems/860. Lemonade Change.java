class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0, len = bills.length;
        
        if(len < 1){
            return true;
        }
        
        for(int i = 0; i < len; i++){
            if(bills[i] == 5){
                five++;
            }
            else if(bills[i] == 10){
                if(five < 1){
                    return false;
                }
                five--;
                ten++;
            }
            else{
                if(ten >= 1 && five >= 1){
                    ten--;
                    five--;
                }
                else if(five > 2){
                    five -= 3;
                }
                else{
                    return false;
                }
            }
        }
        
        return true;
    }
}
