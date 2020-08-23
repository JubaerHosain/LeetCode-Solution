class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length-1, area = 0;
        
        while(i<j){
            if(height[i] < height[j]){
                area = Math.max(area, height[i]*(j-i));
                i++;
            }
            else{
                area = Math.max(area, height[j]*(j-i));
                j--;
            }
        }
        
        return area;
    }
}
