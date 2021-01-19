package Stack;

import java.util.Stack;

public class BalancedBrackets {
    static boolean ispar(String x)
    {
        Stack<Character> stack = new Stack<>();
        for (char ch: x.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                if(ch == ')' && stack.peek() == '(' ||
                        ch == ']' && stack.peek() == '[' ||
                        ch == '}' && stack.peek() == '{' ) stack.pop();
                else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }
}
