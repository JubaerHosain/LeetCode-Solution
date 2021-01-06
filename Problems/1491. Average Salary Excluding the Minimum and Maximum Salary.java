class Solution {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        long sum = 0;
        for(int i = 0; i < salary.length; i++){
            sum += salary[i];
            min = Math.min(min, salary[i]);
            max = Math.max(max, salary[i]);
        }
        sum -= (min+max);
        
        return (double)sum/(salary.length-2);
    }
}
