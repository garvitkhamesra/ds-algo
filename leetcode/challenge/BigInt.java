package challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * User: garvit
 * Date: 16/02/21 10:19 AM
 */
public class BigInt {
    private String num;
    private int sign;
    public BigInt(String num) {
        this.num = num;
    }

    @Override
    public String toString() {
        String mag = sign == -1 ? "-" : "";
        return mag + num;
    }

    public static BigInt add(BigInt num1, BigInt num2) {
        checkNumbers(num1, num2);
        if (num1.num.contains("-")) {
            num1.sign = -1;
            num1.num = num1.num.substring(1);
        }
        if (num2.num.contains("-")) {
            num2.sign = -1;
            num2.num = num2.num.substring(1);
        }
        if (num1.num.contains("+")) {
            num1.sign = 1;
            num1.num = num1.num.substring(1);
        }
        if (num2.num.contains("+")) {
            num2.sign = 1;
            num2.num = num2.num.substring(1);
        }
        BigInt res = new BigInt("");
        if (num1.sign == num2.sign) {
            res.num = add(num1.num, num2.num);
            res.sign = num1.sign;
        } else {
            res = diff(num2.num, num1.num);
            if (isSmaller(num1.num, num2.num)) {
                res.sign = num2.sign;
            } else {
                res.sign = num1.sign;
            }
        }
        return res;
    }

    public static BigInt subtract(BigInt num1, BigInt num2) {
        checkNumbers(num1, num2);
        if (num1.num.contains("-")) {
            num1.sign = -1;
            num1.num = num1.num.substring(1);
        }
        if (num2.num.contains("-")) {
            num2.sign = -1;
            num2.num = num2.num.substring(1);
        }
        if (num1.num.contains("+")) {
            num1.sign = 1;
            num1.num = num1.num.substring(1);
        }
        if (num2.num.contains("+")) {
            num2.sign = 1;
            num2.num = num2.num.substring(1);
        }
        BigInt res = new BigInt("");
        if (num1.sign != num2.sign) {
            res.num = add(num1.num, num2.num);
            res.sign = num1.sign;
        } else {
            res = diff(num2.num, num1.num);
            if (isSmaller(num1.num, num2.num)) {
                res.sign = num2.sign == -1 ? 1 : -1;
            } else {
                res.sign = num1.sign;
            }
        }
        return res;

    }

    private static void checkNumbers(BigInt num1, BigInt num2) {
        if (num1.num.lastIndexOf("-") > 0 || num2.num.lastIndexOf("-") > 0) {
            throw new NumberFormatException("Wrong number definition");
        }
        if (num1.num.lastIndexOf("+") > 0 || num2.num.lastIndexOf("+") > 0) {
            throw new NumberFormatException("Wrong number definition");
        }
    }

    private static String add(String num1, String num2) {
        int maxLength = Math.max(num1.length(), num2.length());
        String a = leftPadding(num1, maxLength);
        String b = leftPadding(num2, maxLength);

        int carry = 0;
        String result = "";

        for (int i = a.length() - 1; i >= 0; i--) {
            int digit1 = a.charAt(i) - 48;
            int digit2 = b.charAt(i) - 48;

            int resultingNumber = digit1 + digit2 + carry;
            if (resultingNumber >= 10) {
                result = (resultingNumber % 10) + result;
                carry = 1;
            } else {
                result = resultingNumber + result;
                carry = 0;
            }
        }
        if (carry > 0) {
            result = carry + result;
        }
        return result;
    }

    private static String leftPadding(String num, int length) {
        if (num.length() >= length) {
            return num;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length - num.length(); i++) {
            sb.append("0");
        }
        return sb.toString() + num;
    }

    private static BigInt diff(String num1, String num2) {
        if (isSmaller(num1, num2)) {
            String t = num1;
            num1 = num2;
            num2 = t;
        }
        String str = "";
        int n1 = num1.length(), n2 = num2.length();
        int diff = n1 - n2;

        int carry = 0;
        for (int i = n2 - 1; i >= 0; i--) {
            int sub = (((int)num1.charAt(i + diff) - (int)'0') - ((int)num2.charAt(i) - (int)'0') - carry);
            if (sub < 0) {
                sub = sub + 10;
                carry = 1;
            } else {
                carry = 0;
            }
            str += String.valueOf(sub);
        }

        for (int i = n1 - n2 - 1; i >= 0; i--) {
            if (num1.charAt(i) == '0' && carry > 0) {
                str += "9";
                continue;
            }
            int sub = (((int)num1.charAt(i) - (int)'0') - carry);
            if (i > 0 || sub > 0) {
                str += String.valueOf(sub);
            }
            carry = 0;
        }

        return new BigInt(new StringBuilder(str).reverse().toString());
    }

    private static boolean isSmaller(String str1, String str2) {
        int n1 = str1.length(), n2 = str2.length();

        if (n1 < n2)
            return true;
        if (n2 < n1)
            return false;

        for (int i = 0; i < n1; i++) {
            if (str1.charAt(i) < str2.charAt(i))
                return true;
            else if (str1.charAt(i) > str2.charAt(i))
                return false;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while (testCases > 0) {
            String input = br.readLine();
            String[] op = input.split(" ");
            if (op.length < 3) throw new NumberFormatException("Wrong input");

            switch (op[0]) {
                case "ADD":
                    System.out.println(add(new BigInt(op[1]), new BigInt(op[2])));
                    break;
                case "SUB":
                    System.out.println(subtract(new BigInt(op[1]), new BigInt(op[2])));
                    break;
                default:
                    System.out.println("Wrong Operation");
                    break;
            }
            testCases--;
        }
    }
}
