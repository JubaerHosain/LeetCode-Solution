class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merge = new int[nums1.length+nums2.length];
        
        int i = 0, j = 0, index = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                merge[index++] = nums1[i++];
            }
            else{
                merge[index++] = nums2[j++];
            }
        }
        
        if(i == nums1.length){
            while(j < nums2.length){
                merge[index++] = nums2[j++];
            }
        }
        else{
            while(i < nums1.length){
                merge[index++] = nums1[i++];
            }
        }
        
        double result;
        if(merge.length%2 == 0){
            int mid = merge[(merge.length/2)-1] + merge[merge.length/2];
            result = mid/2.0;
        }
        else{
            result = merge[merge.length/2];
        }
        
        return result;
    }
}
