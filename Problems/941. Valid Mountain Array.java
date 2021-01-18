class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3) {
            return false;
        }
        
        int left = -1, right = -1;
        for(int i = 1; i < arr.length-1; i++) {
            if(arr[i-1] < arr[i] && arr[i] > arr[i+1]) {
                left = i-1;
                right = i+1;
                
                while(left > 0 && arr[left-1] < arr[left]) left--;
                while(right < arr.length-1 && arr[right] > arr[right+1]) right++;
                
                break;
            }
        }
        
        return (left == 0 && right == arr.length-1);
    }
}
