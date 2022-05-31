package chapter8;


import java.util.Stack;

public class TowerOfHanoi {
    static class Tower {
        private Stack<Integer> disks;
        private int index;

        public Tower(int i) {
            disks = new Stack<>();
            index = i;
        }

        public int index() {
            return index;
        }

        public void add(int diskSize) {
            if (!disks.isEmpty() && disks.peek() <= diskSize) {
                System.out.println("Error in question");
            } else {
                disks.push(diskSize);
            }
        }

        public void moveDisks(int i, Tower destination, Tower buffer) {
            if (i > 0) {
                moveDisks(i-1, buffer, destination); // just for for loop, how many disks
                moveTopTo(destination);
                buffer.moveDisks(i-1, destination, this);
            }
        }

        private void moveTopTo(Tower destination) {
            Integer pop = disks.pop();
            destination.add(pop);
        }

        @Override
        public String toString() {
            return "Tower{" +
                    "disks=" + disks +
                    ", index=" + index +
                    '}';
        }
    }

    public static void main(String[] args) {
        Tower[] towers = new Tower[3];

        for (int i = 0; i < 3; i++) {
            towers[i] = new Tower(i);
        }

        for (int i = 4; i >= 0; i--) {
            towers[0].add(i);
        }

        towers[0].moveDisks(5, towers[2], towers[1]);
        System.out.println("debug "+ towers[2].toString());
    }
}
