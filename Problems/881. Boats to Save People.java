class Solution {
    public int numRescueBoats(int[] people, int limit) {
        if(people.length == 0){
            return 0;
        }
        else if(people.length == 1){
            return 1;
        }
        
        Arrays.sort(people);
        int i = 0, j = people.length-1, cnt = 0;
        
        while(i <= j){
            if(people[i]+people[j] <= limit){
                i++;
            }
            j--;
            cnt++;
        }
        
        return cnt;
    }
}
