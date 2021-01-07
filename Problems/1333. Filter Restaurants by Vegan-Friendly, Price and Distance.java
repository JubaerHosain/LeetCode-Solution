class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        Arrays.sort(restaurants, (a,b) -> 
            (a[1]==b[1] ? b[0]-a[0] : b[1]-a[1])
        );
        
        List<Integer> result = new ArrayList<>();
        for(int[] arr: restaurants) {
            if((veganFriendly == arr[2] || veganFriendly == 0) 
              && maxPrice >= arr[3] && maxDistance >= arr[4]) {
                result.add(arr[0]);
            }
        }
        
        return result;
    }
}
