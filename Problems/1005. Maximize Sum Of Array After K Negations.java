class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        int len = A.length, sum = 0;
        
        Arrays.sort(A);
        for(int i = 0; i < len; i++){
            if(A[i] < 0 && K > 1){
                A[i] = -A[i];
                K--;
            }
        }
        
        Arrays.sort(A);
        if((K&1) == 1){
            A[0] = -A[0];
        }
        
        for(int a: A){
            sum += a;
        }
        
        return sum;
    }
}
