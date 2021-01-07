class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        
        
        int index = 0;
        int[] result = new int[k];
        int low = 0, high = arr.length-1;
        int m = arr[(arr.length-1)/2];
        
        while(low <= high) {
            if(arr[high]-m >= m-arr[low]) {
                result[index++] = arr[high--];
            } else {
                result[index++] = arr[low++];
            }
            
            if(index == k) {
                break;
            }
        }
        
        return result;
    }
}
