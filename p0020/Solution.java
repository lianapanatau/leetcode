package p0020;

import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()"));
    }

    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }

        var stack = new Stack<Character>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                Character pop = stack.pop();
                if (ch == ')' && pop != '(') {
                    return false;
                }

                if (ch == '}' && pop != '{') {
                    return false;
                }

                if (ch == ']' && pop != '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}