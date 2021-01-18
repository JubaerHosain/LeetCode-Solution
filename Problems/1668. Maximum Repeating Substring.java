class Solution {
    public int maxRepeating(String sequence, String word) {
        int count = 0;
        String tmp = word;
        
        while(sequence.contains(tmp)) {
            count++;
            tmp += word;
        }
        
        return count;
    }
}
