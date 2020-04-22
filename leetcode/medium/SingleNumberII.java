/**
 * Created by dot on 20/4/20 9:19 AM
 * Package: PACKAGE_NAME
 */
public class SingleNumberII {
    /*
    * Because the max integer value will go upto 32 bits
    * */
    private static final int INT_SIZE = 32;

    public int singleNumber(final int[] A) {

        int result = 0;
        for(int bitIterator = 0; bitIterator < INT_SIZE; bitIterator++) {
            int sum = 0, mask = (1 << bitIterator);
            /*
            * Mask:
            * 1 << any number means -> it will add that number of 0 in right of 1
            * 1 << 2 -> 100
            * Why we need mask? So when we do addition we will only count 1's,
            * this mask will help us do that
            * */
            for(int arrIterator = 0; arrIterator < A.length; arrIterator++) {
                /*
                * The next line is to do the sum.
                * So 1 & 1 -> 0
                * 1 & 0 -> 0
                * The if statement will add only when there is 1 present at the position
                * */
                if((A[arrIterator] & mask) != 0) {
                    sum++;
                }
            }

            /*
            * So if there were 3 1's and 1 0's
            * the result will become 0
            * */
            if(sum % 3 == 1) {
                result |= mask;
            }
        }

        /*So if we dry run our code with the above example
        * bitIterator = 0; result = 0; mask = 1;
        * after for loop the sum at position 0 will became 3. The if
        * condition will be true for 5 as - (101 & 001 -> 001) and false for 6
        * (110 & 001 -> 000)
        * result -> 0 | 1 -> 0
        *
        * bitIterator = 1; result = 0; mask = 10;
        * after for loop the sum at position 1 will became 1. The if
        * condition will be true for 6 as - (110 & 010 -> 010) and false for 5
        * (101 & 010 -> 000)
        * result -> 00 | 10 -> 10
        *
        * bitIterator = 2; result = 10; mask = 100;
        * after for loop the sum at position 2 will became 4. The if
        * condition will be true for 6 as - (110 & 100 -> 100) and true for 5
        * (101 & 100 -> 100)
        * result -> 10 | 100 -> 110 (answer)
        * */
        return result;
    }

    public int singleNumberOptimized(int[] A) {
        int one = 0, two = 0;
        /*
        * Two sets to maintain the count the number has appeared
        * one -> 1 time
        * two -> 2 time
        * three -> not in any set
        * */
        for(int arrIterator = 0; arrIterator < A.length; arrIterator++){
            /*
            * IF one has a number already remove it, and it does not have that number
            * appeared previously and it is not there in 2 then add it in one.
            * */
            one = (one ^ A[arrIterator]) & ~two;
            /*
             * IF two has a number already remove it, and it does not have that number
             * appeared previously and it is not there in 1 then add it in two.
             * */
            two = (two ^ A[arrIterator]) & ~one;
        }

        /*
        * Dry run
        * First Appearance : one will have two will not
        * Second Appearance : one will remove and two will add
        * Third Appearance: one will not able to add as it is there in two
        * and two will remove because it was there.
        *
        * So one will have only which has occurred once and two will not have anything
        * */
        return one;
    }
}
