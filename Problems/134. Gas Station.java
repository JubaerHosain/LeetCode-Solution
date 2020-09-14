class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length, diffSum = 0;
        for(int i = 0; i < len; i++){
            diffSum += gas[i]-cost[i];
        }
        
        if(diffSum < 0){
            return -1;
        }
        
        int tank = 0, start = 0;
        for(int s = 0; s < len; s++){
            tank += gas[s]-cost[s];
            
            if(tank < 0){
                tank = 0;
                start = s+1;
            }
        }
        
        return start;
    }
}
