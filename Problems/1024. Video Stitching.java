class Solution {
    public int videoStitching(int[][] clips, int T) {
        int left = 0, right = 0, res = 0;
        
        while(right < T){
            for(int i = 0; i < clips.length; i++){
                int l = clips[i][0];
                int r = clips[i][1];
                
                if(l <= left && r > right){
                    right = r;
                }
            }
            
            if(left == right){
                return -1;
            }
            
            left = right;
            res++;
        }
        
        return res;
    }
}
