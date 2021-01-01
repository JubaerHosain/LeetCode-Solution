class Solution {
    class Node{
        int index;
        int val;
        
        public Node(int index, int val){
            this.index = index;
            this.val = val;
        }
    }
    
    public int[] kWeakestRows(int[][] mat, int k) {
        List<Node> list = new ArrayList<>();
        
        for(int i =  0; i < mat.length; i++){
            int count = 0;
            
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    break;
                }
                count++;
            }
            list.add(new Node(i, count));
        }
        
        Collections.sort(list, new Comparator<Node>(){
            public int compare(Node a, Node b){
                if(a.val != b.val) return a.val-b.val;
                else return a.index-b.index;
            }
        });
        
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = list.get(i).index;
        }
        
        return result;
    }
}
