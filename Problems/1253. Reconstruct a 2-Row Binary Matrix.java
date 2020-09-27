class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        res.add(new ArrayList<Integer>());
        
        for(int i = 0; i < colsum.length; i++){
            if(colsum[i] == 0){
                res.get(0).add(0);
                res.get(1).add(0);
            }
            else if(colsum[i] == 2){
                if(upper > 0 && lower > 0){
                    res.get(0).add(1);
                    res.get(1).add(1);
                    upper--;
                    lower--;
                }
                else{
                    return new ArrayList<List<Integer>>(); 
                }
            }
            else{
                res.get(0).add(-1);
                res.get(1).add(-1);
            }
        }
        
        for(int i = 0; i < colsum.length; i++){
            if(colsum[i] == 1){
                if(upper > 0){
                    res.get(0).set(i,1);
                    res.get(1).set(i,0);
                    upper--;
                }
                else if(lower > 0){
                    res.get(0).set(i,0);
                    res.get(1).set(i,1);
                    lower--;
                }
                else{
                    return new ArrayList<List<Integer>>(); 
                }
            }
        }
        
        return (upper==0&&lower==0) ? res:new ArrayList<List<Integer>>(); 
    }
}
