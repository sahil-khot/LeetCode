class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } 
            else {
                if (stack.isEmpty()) {
                    return false;
                } 
                else {
                    char val = stack.pop();
                    if ((ch == ')' && val != '(') || (ch == ']' && val != '[') || (ch == '}' && val != '{')) {
                        return false;
                    }

                }
            }
        }
        return stack.isEmpty();
    }
}