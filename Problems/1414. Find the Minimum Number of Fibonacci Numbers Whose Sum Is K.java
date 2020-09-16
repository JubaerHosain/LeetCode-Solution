class Solution {
    public int findMinFibonacciNumbers(int k) {
        List<Integer> fibs = new ArrayList<>();
        fibs.add(1);
        
        int first = 1, second = 1;
        while((first+second) <= k){
            int next = first+second;
            
            fibs.add(next);
            first = second;
            second = next;
        }
        
        int cnt = 0, index = fibs.size()-1, sum = 0;
        while(sum < k && index >= 0){
            int val = fibs.get(index), rest = k-sum;
            
            if(rest >= val){
                int div = rest/val;
                sum += div*val;
                index--;
                
                cnt++;
            }
            else{
                index--;
            }
        }
        
        return cnt;
    }
}
