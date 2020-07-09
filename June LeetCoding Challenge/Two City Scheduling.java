class Solution {
    public int twoCitySchedCost(int[][] costs) {
        //Sort based on differnce between two colum
        Arrays.sort(costs, new Comparator<int[]>(){
            public int compare(final int[] cost1, final int[] cost2){
                return (cost2[1]-cost2[0])-(cost1[1]-cost1[0]);
            }
        });
        
        int result = 0, n = costs.length;
        for(int i = 0; i < n; i++){
            if(i < n/2){
                result += costs[i][0];
            }
            else{
                result += costs[i][1];
            }
        }
        
        return result;
    }
}
