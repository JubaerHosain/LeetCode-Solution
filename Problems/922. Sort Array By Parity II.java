class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int start = 0, end = A.length-1;
        
        while(start < A.length-1){
            if(A[start]%2 == 0){
                start += 2;
            } else if(A[end]%2 != 0){
                end -= 2;
            } else {
                int temp = A[start];
                A[start] = A[end];
                A[end] = temp;
            }
        }
        
        return A;
    }
}
