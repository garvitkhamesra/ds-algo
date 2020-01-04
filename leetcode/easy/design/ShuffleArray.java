package easy.design;

import java.util.Random;

/**
 * User: garvit
 * Date: 04/01/20 4:16 PM
 */

/*
Shuffle array
https://leetcode.com/explore/interview/card/top-interview-questions-easy/98/design/670/
*/

public class ShuffleArray {
    private int[] array;
    private int[] original;

    Random rand = new Random();

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public ShuffleArray(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }
}

/*
We can cut down the time and space complexities of shuffle with a bit of cleverness - namely, by swapping elements
around within the array itself, we can avoid the linear space cost of the auxiliary array and the linear time cost of
list modification.
Algorithm
The Fisher-Yates algorithm is remarkably similar to the brute force solution. On each iteration of the algorithm,
we generate a random integer between the current index and the last index of the array. Then,
we swap the elements at the current index and the chosen index - this simulates drawing (and removing) the element
from the hat, as the next range from which we select a random index will not include the most recently processed one.
One small, yet important detail is that it is possible to swap an element with itself - otherwise, some array
permutations would be more likely than others. To see this illustrated more clearly, consider the animation below:
*/
