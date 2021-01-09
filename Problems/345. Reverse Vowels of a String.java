class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length-1;
        
        while(left <= right) {
            if(isVowel(arr[left]) && isVowel(arr[right])) {
                swap(arr, left, right);
                left++; 
                right--;
            } else if(!isVowel(arr[left])) {
                left++;
            } else {
                right--;
            }
        }
                      
        return String.valueOf(arr);
    }
                      
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
            c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
