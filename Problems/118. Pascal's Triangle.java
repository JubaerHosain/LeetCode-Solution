class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        
        if(numRows == 0){
            return list;
        }
        
        List<Integer> row = new ArrayList<>();
        row.add(1);
        list.add(row);
        
        if(numRows == 1){
            return list;
        }
        
        row = new ArrayList<>();
        row.add(1);
        row.add(1);
        list.add(row);
        
        if(numRows == 2){
            return list;
        }
        
        for(int i = 2; i < numRows; i++){
            row = new ArrayList<>();
            row.add(1);
            
            for(int j = 1; j < i; j++){
                row.add(list.get(i-1).get(j) + list.get(i-1).get(j-1));
            }
            
            row.add(1);
            list.add(row);
        }
        
        return list;
    }
}
