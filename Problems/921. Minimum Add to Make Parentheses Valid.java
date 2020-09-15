class Solution {
    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        
        int res = 0;
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '('){
                stack.push(')');
            }
            else{
                if(!stack.empty() && stack.peek() == S.charAt(i)){
                    stack.pop();
                }
                else{
                    res++;
                }
            }
        }
        
        res += stack.size();
        
        return res;
    }
}
