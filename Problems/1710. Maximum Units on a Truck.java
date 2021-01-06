class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[1]-a[1];
            }
        });
        
        int maxUnit = 0, index = 0;
        while(index < boxTypes.length && truckSize > 0){
            if(truckSize >= boxTypes[index][0]){
                maxUnit += (boxTypes[index][0]*boxTypes[index][1]);
                truckSize -= boxTypes[index][0];
            } else {
                maxUnit += (truckSize*boxTypes[index][1]);
                truckSize = 0;
            }
            index++;
        }
        
        return maxUnit;      
    }
}
