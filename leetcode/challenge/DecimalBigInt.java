package challenge;

/**
 * User: garvit
 * Date: 16/02/21 7:12 PM
 */

import java.util.Arrays;

public class DecimalBigInt {
    private int[] digits;


    public DecimalBigInt(int... digits) {
        // we count how much leading zeroes there are.
        int zeroCount = 0;
        // zero == until now no nonzero digit seen.
        boolean zero = true;
        for(int digit : digits) {
            if(zero) {
                if (digit != 0) {
                    zero = false;
                }
                else {
                    zeroCount ++;
                }
            }
        }
        // cut off leading zeros by copying only the rest.
        // (We always do the copying, since we want to be independent
        //  from the input array.)
        this.digits = Arrays.copyOfRange(digits, zeroCount, digits.length);
    }


    /**
     * calculates the sum {@code this + that}.
     */
    public DecimalBigInt plus(DecimalBigInt that) {
        int[] result = new int[Math.max(this.digits.length,
                that.digits.length)+ 1];

        addDigits(result, result.length-1, this.digits);
        addDigits(result, result.length-1, that.digits);

        return new DecimalBigInt(result);
    }

    /**
     * adds all the digits from the addend array to the result array.
     */
    private void addDigits(int[] result, int resultIndex,
                           int... addend)
    {
        int addendIndex = addend.length - 1;
        while(addendIndex >= 0) {
            addDigit(result, resultIndex,
                    addend[addendIndex]);
            addendIndex--;
            resultIndex--;
        }
    }


    /**
     * adds one digit from the addend to the corresponding digit
     * of the result.
     * If there is carry, it is recursively added to the next digit
     * of the result.
     */
    private void addDigit(int[] result, int resultIndex,
                          int addendDigit)
    {
        int sum = result[resultIndex] + addendDigit;
        result[resultIndex] = sum;
        int carry = sum;
        if(carry > 0) {
            addDigit(result, resultIndex - 1, carry);
        }
    }


    /**
     * a test method, which demonstrates the usage.
     */
    public static void main(String[] params) {
        // test of constructor + toString
        DecimalBigInt d = new DecimalBigInt(0,0, 7, 5, 2, 12345);
        System.out.println("d: " + d);

        // test of plus
        DecimalBigInt sum = d.plus(d).plus(d);
        System.out.println("sum: " + sum);

    }


}