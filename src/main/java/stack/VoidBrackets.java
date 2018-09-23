package stack;

import java.util.Stack;

public class VoidBrackets {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int j = s.length();
        for (int i = 0; i < j; i++) {
            if (!stack.isEmpty() && translate(stack.peek()) == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    private char translate(char c) {
        if (c == '(' || c == '{' || c == '[') {
            if (c == '(')
                c += 1;
            else
                c += 2;
        } else {
            if (c == ')')
                c -= 1;
            else
                c -= 2;
        }
        return c;
    }
}
