class Solution {
    public String reverseWords(String string) {
        string = string.trim();
        
        if(string.length() == 0){
            return string;
        }
        
        String[] arr = string.split("\\s+"); 
        
        String result = arr[arr.length-1];
        for(int i = arr.length-2; i >= 0; i--){
            result += " " + arr[i];
        }
        
        return result;
    }
}
