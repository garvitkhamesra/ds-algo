package strings;

import java.util.Stack;

public class BackSpaceCompare {
    public static boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for (char ch : S.toCharArray()) {
            if (ch == '#') {
                if (!stack1.empty()) stack1.pop();
            } else {
                stack1.push(ch);
            }
        }

        for (char ch : T.toCharArray()) {
            if (ch == '#') {
                if (!stack2.empty()) stack2.pop();
            } else {
                stack2.push(ch);
            }
        }
        if (stack1.size() != stack2.size()) return false;

        int i = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (stack1.pop() != stack2.pop()) return false;
        }

        return true;
    }
}
