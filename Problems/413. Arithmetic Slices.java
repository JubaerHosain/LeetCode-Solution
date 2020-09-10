class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 3){
            return 0;
        }
        
        int[] count  = new int[A.length-1];
        for(int i = 0; i < A.length-1; i++){
            count[i]  = A[i] -  A[i+1];
        }
        
        int res = 0, cnt = 1;
        for(int i = 0; i < count.length-1; i++){
            if(count[i] == count[i+1]){
                cnt++;
            }
            else{
                if(cnt >= 2){
                    cnt--;
                    res += (cnt*(cnt+1)/2);
                }
                cnt = 1;
            }
        }
        if(cnt >= 2){
            cnt--;
            res += (cnt*(cnt+1)/2);
        }
            
        return res;
    }
}
