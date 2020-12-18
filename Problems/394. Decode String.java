class Solution {
    public String decodeString(String s) {
        Stack<Integer> iStack = new Stack<>();
        Stack<String> sStack = new Stack<>();
        
        String result = "";
        int i = 0;
        while(i < s.length()){
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)){
                int num = 0;
                while(Character.isDigit(s.charAt(i))){
                    num = num*10 + s.charAt(i)-'0';
                    i++;
                }
                iStack.push(num);
            } else if(ch == '['){
                sStack.push(result);
                result = "";
                i++;
            } else if(ch == ']'){
                StringBuilder sb = new StringBuilder(sStack.pop());
                int count = iStack.pop();
                for(int k = 0; k < count; k++){
                    sb.append(result);
                }
                result = sb.toString();
                i++;
            } else{
                result += s.charAt(i);
                i++;
            }
        }
        
        return result;
    }
}
