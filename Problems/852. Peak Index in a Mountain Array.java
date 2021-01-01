class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0, high = arr.length;
        
        while(low <= high){
            int mid = (low+high)/2;
            
            if(arr[mid] < arr[mid+1]){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        
        return low;
    }
}
