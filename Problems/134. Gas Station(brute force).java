class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        
        for(int s = 0; s < len; s++){
            int tank = 0;
            boolean possible = true;
            
            for(int i = s; i < s+len; i++){
                tank += gas[i%len] - cost[i%len];
                
                if(tank < 0){
                    possible = false;
                }
            }
            
            if(possible){
                return s;
            }
        }
        
        return -1;
    }
}
