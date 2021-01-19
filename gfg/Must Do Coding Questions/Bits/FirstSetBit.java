package Bits;

public class FirstSetBit {
    static int Right_most_setbit(int num)
    {
        int pos = 1;
        // counting the position of first set bit
        for (int i = 0; i < 32; i++) {
            if ((num & (1 << i))== 0)
                pos++;

            else
                break;
        }
        return pos;
    }
    static int PositionRightmostSetbit2(int n)
    {
        // Position variable initialize
        // with 1 m variable is used to
        // check the set bit
        int position = 1;
        int m = 1;

        while ((n & m) == 0) {

            // left shift
            m = m << 1;
            position++;
        }
        return position;
    }
}
