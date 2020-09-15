class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(final int[] a, final int[] b){
                return a[0]-b[0];
            }
        });
        
        int len = people.length;
        int[][] res = new int[len][2];
        for(int i = 0; i < len; i++){
            res[i][0] = -1;
        }
        
        
        for(int i = 0; i < len; i++){
            int cnt = people[i][1];
            
            for(int j = 0; j < len; j++){
                if(res[j][0] == -1 && cnt == 0){
                    res[j][0] = people[i][0];
                    res[j][1] = people[i][1];
                    break;
                }
                else if(res[j][0] == -1 || res[j][0] >= people[i][0]){
                    cnt--;
                }
            }
        }
        
        return res;
    }
}
