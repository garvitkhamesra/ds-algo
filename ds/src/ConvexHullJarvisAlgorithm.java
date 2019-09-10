import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ConvexHullJarvisAlgorithm {
    // or wrapping
    public ArrayList<Point> hull = new ArrayList<>();
    public void convexHull(Point points[], int size) {
        // If less than 2 points
        if (size < 3) return;
        // Find right most point (x value largest).
        int farthestX = Point.findPoint("x", "max", points);
        int first = farthestX;
        int last = farthestX;
        do {
            hull.add(points[first]);

            // select next point in the array to farthest point and mod to avoid array out of bound exception
            int secondPoint = (first + 1)%size;

            // iterating every point so that we find nearest to first point
            for (int i = 0; i < size; i++) {
                // If counterclockwise check next nearest otherwise that is the only point nearest and counterclockwise
                if (Point.orientation(points[first], points[i], points[secondPoint]) < 0)
                    secondPoint = i; // changing to next point
            }
            first = secondPoint; // changing the initial point to next selected point

        } while (first != last); // when reach the beginning point
    }

    public void printConvexHull() {
        for (Point temp : hull)
            System.out.println("(" + temp.x + ", " + temp.y + ")");
    }

    public static void main(String[] args) {
        Point points[] = new Point[7];
        points[0]=new Point(0, 3);
        points[1]=new Point(2, 3);
        points[2]=new Point(1, 1);
        points[3]=new Point(2, 1);
        points[4]=new Point(3, 0);
        points[5]=new Point(0, 0);
        points[6]=new Point(3, 3);

        int n = points.length;

        ConvexHullJarvisAlgorithm convexHullJarvisAlgorithm = new ConvexHullJarvisAlgorithm();
        convexHullJarvisAlgorithm.convexHull(points, n);
        convexHullJarvisAlgorithm.printConvexHull();
    }
}
