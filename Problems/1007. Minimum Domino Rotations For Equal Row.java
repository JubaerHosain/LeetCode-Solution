class Solution {
    private int minSwap(int target, int[] A, int[] B){
        int min = 0;
        
        for(int i = 0; i < A.length; i++){
            if(target != A[i] && target != B[i]){
                return Integer.MAX_VALUE;
            }
            else if(target != A[i]){
                min++;
            }
        }
        
        return min;
    }
    
    
    public int minDominoRotations(int[] A, int[] B) {
        int min1 = Math.min(minSwap(A[0], A, B), minSwap(A[0], B, A));
        int min2 = Math.min(minSwap(B[0], A, B), minSwap(B[0], B, A));
        
        return Math.min(min1, min2) == Integer.MAX_VALUE ? -1 : Math.min(min1, min2);
    }
}
