class Solution {
    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> index = new Stack<>();
        index.push(-1);
        
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(')');
                index.push(i);
            }
            else{
                if(!stack.empty() && stack.peek() == s.charAt(i)){
                    stack.pop();
                    index.pop();
                    max = Math.max(i-index.peek(), max);
                }
                else{
                    index.push(i);
                }
            }
        }
        
        return max;
    }
}
