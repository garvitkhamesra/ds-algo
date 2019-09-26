package week2.assignment;

import edu.princeton.cs.algs4.StdIn;

public class Permutation {
    public static void main(String[] args) {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<String>();
        int temp = Integer.parseInt(args[0]);
        while (!StdIn.isEmpty() && temp >= 0) {
            String value = StdIn.readString();
            randomizedQueue.enqueue(value);
            temp--;
        }
    }
}

