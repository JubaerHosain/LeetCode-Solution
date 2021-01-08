class Solution {
    public String reorganizeString(String S) {
        int[] count = new int[26];
        for(char ch: S.toCharArray()) {
            count[ch-'a']++;
        }
        
        Queue<int[]> pq = new PriorityQueue<>((a,b)->(b[1]-a[1]));
        for(int i = 0; i < 26; i++) {
            if(count[i] > 0) {
                pq.add(new int[]{i, count[i]});
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(pq.size() > 1) {
            int[] a = pq.poll();
            int[] b = pq.poll();
            
            sb.append((char)(a[0]+'a'));
            sb.append((char)(b[0]+'a'));
            a[1]--; b[1]--;
            
            if(a[1] > 0) {
                pq.add(new int[]{a[0], a[1]});
            }
            if(b[1] > 0) {
                pq.add(new int[]{b[0], b[1]});
            }
        }
        
        if(!pq.isEmpty()) {
            int[] a = pq.poll();
            if(a[1] > 1) {
                return "";
            } else {
                sb.append((char)(a[0]+'a'));
            }
        }
        
        return sb.toString();
    }
}
