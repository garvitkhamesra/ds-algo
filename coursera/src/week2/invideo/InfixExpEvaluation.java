import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfixExpEvaluation {
    public static void main(String[] args) {
        String exp = "(1+((4+1)*(4*5)))";
        int val = 0;
        Stack numStack = new Stack(exp.length());
        Stack oprStack = new Stack(exp.length());
        Pattern patternOp = Pattern.compile("[-*+/]");
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '(') continue;
            if (Character.isDigit(ch)) {
                numStack.push(Integer.parseInt(String.valueOf(ch)));
                continue;
            }
            Matcher matcher1 = patternOp.matcher(String.valueOf(ch));
            if (matcher1.matches()) {
                oprStack.push(ch);
                continue;
            }
            if (ch == ')') {
                int a = (int)numStack.pop();
                int b = (int)numStack.pop();
                char op = (char) oprStack.pop();
                val = InfixExpEvaluation.eval(op, a, b);
                numStack.push(val);
            }
        }

        System.out.println(val);
    }

    private static int eval(char op, int a, int b) {
        int val = 0;
        switch (op) {
            case '+':
                val = a + b;
                break;
            case '*':
                val = a * b;
                break;
            case '-':
                val = a - b;
                break;
            case '/':
                val = a / b;
                break;
            default:
                System.out.println("Not a valid operation");
        }
        return val;
    }
}
