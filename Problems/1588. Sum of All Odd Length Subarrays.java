class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0, len = arr.length;
        
        for(int i = 1; i < len; i++){
            arr[i] += arr[i-1];
        }
        
        sum = arr[len-1];
        for(int l = 3; l <= len; l+=2){
            sum += arr[l-1];
            for(int i = l; i < len; i++){
                sum += arr[i]-arr[i-l];
            }
        }
        
        return sum;
    }
}
