package Heap;


import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedian
{
    static PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> min = new PriorityQueue<>();

    public static void insertHeap(int x)
    {
        if(max.size()==0 || x<max.peek())
        {
            max.add(x);
        }
        else
        {
            min.add(x);
        }
        balanceHeaps();
    }

    // Function to balance Heaps
    public static void balanceHeaps()
    {
        int size1=max.size();
        int size2=min.size();

        if(Math.abs(size1-size2)>1)
        {
            if(size1>size2)
            {
                int p=max.poll();
                min.add(p);
            }
            else
            {
                int p=min.poll();
                max.add(p);
            }
        }
        // add your code here
    }

    // function to getMedian
    public static double getMedian()
    {
        int size1=max.size();
        int size2=min.size();
        if(size1==size2)
        {
            return (double)((double)max.peek()+(double)min.peek())/2;
        }
        else
        {
            if(size1>size2)
            {
                return max.peek();
            }
            else
            {
                return min.peek();
            }
        }
    }
}