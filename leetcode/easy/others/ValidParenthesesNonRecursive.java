package others;

import java.util.Stack;

/**
 * Created by dot on 9/1/20 8:45 AM
 * Package: others
 */
public class ValidParenthesesNonRecursive {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                if (ch == ')') {
                    if (stack.peek().equals('(')) {
                        stack.pop();
                        continue;
                    } else {
                        return false;
                    }
                } else if (ch == ']') {
                    if (stack.peek().equals('[')) {
                        stack.pop();
                        continue;
                    } else {
                        return false;
                    }
                } else {
                    if (ch == '}' && stack.peek().equals('{')) {
                        stack.pop();
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }
}


    /*public boolean isValid(String s) {
        int n = s.length();
        if (n == 0) return true;
        if (n%2 != 0) return false;
        char[] brak = new char[n];
        int top = -1;
        char temp = 'a';
        for (char ch : s.toCharArray()) {
            switch(ch) {
                case '{':
                case '(':
                case '[':
                    brak[++top] = ch;
                    break;
                case '}':
                    if (top == -1) return false;
                    temp = brak[top--];
                    if (temp != '{') return false;
                    break;
                case ')':
                    if (top == -1) return false;
                    temp = brak[top--];
                    if (temp != '(') return false;
                    break;
                case ']':
                    if (top == -1) return false;
                    temp = brak[top--];
                    if (temp != '[') return false;
                    break;
            }
        }
        return top == -1?true:false;
    }*/