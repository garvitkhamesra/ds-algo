import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ConvexHullGramScan {
    // or wrapping
    public Point[] hull;
    private int top = 1;
    public void convexHull(Point points[], int size) {
        // If less than 2 points
        if (size < 3) return;

        hull = new Point[size];
        // Find bottom most point (y value min).
        int lowestY = Point.findPoint("y", "min", points);
        // Set the reference point for sort
        Point.point = points[lowestY];
        // make lowest point at 0 index
        swap(points, lowestY, 0);
        // Sort based on polar angle
        Arrays.sort(points, 1,size, Point.polarOrderComparator());
        hull[0] = points[0];
        hull[1] = points[1];

        // iterate each point and for each point iterate stack
        for (int i = 2; i < size; i++) {
            hull[++top] = points[i];
            while (true) {
                Point nt = hull[top];
                if (Point.orientation(hull[top-2], hull[top-1], hull[top]) < 0) break;
                else {
                    hull[top] = null;
                    top--;
                    hull[top] = nt;
                }
            }
        }
    }

    public void printConvexHull() {
        for (Point temp : hull)
            System.out.println("(" + temp.x + ", " + temp.y + ")");
    }

    private void swap(Point arr[], int a, int b) {
        Point temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        Point points[] = new Point[8];
        points[0]=new Point(0, 3);
        points[1]=new Point(1, 1);
        points[2]=new Point(3, 1);
        points[3]=new Point(4, 4);
        points[4]=new Point(1, 2);
        points[5]=new Point(2, 2);
        points[6]=new Point(0, 0);
        points[7]=new Point(3, 3);

        int n = points.length;

        ConvexHullGramScan convexHullGramScan = new ConvexHullGramScan();
        convexHullGramScan.convexHull(points, n);
        convexHullGramScan.printConvexHull();
    }
}
