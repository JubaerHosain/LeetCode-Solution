class Solution {
    public List<Integer> partitionLabels(String S){
        List<Integer> res = new ArrayList<Integer>();
        int len = S.length();
        int[] cnt = new int[26];
        for(int i = 0; i < len; i++){
            cnt[S.charAt(i)-97] = i;
        }
        
        int start = 0, max = 0;
        for(int i = 0; i < len; i++){
            max = Math.max(max, cnt[S.charAt(i)-97]);
            
            if(i == max){
                res.add(max-start+1);
                start = i+1;
                max = 0;
            }
        }
            
        return res;
    }
}
