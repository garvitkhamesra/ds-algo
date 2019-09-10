import java.util.Comparator;

class Point {
    public int x;
    public int y;
    public static Point point;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static int orientation(Point p1, Point p2, Point p3) {
        return ((p2.y - p1.y)*(p3.x - p2.x) - (p3.y - p2.y)*(p2.x - p1.x));
    }

    static boolean onSegment(Point p, Point q, Point r)
    {
        return q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) &&
                q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y);
    }

    static int findPoint(String axis, String op, Point points[]) {
        int index = 0;
        if (axis.equalsIgnoreCase("x")) {
            if (op.equalsIgnoreCase("max")) {
                for (int i = 1; i < points.length; i++)
                    if (points[index].x < points[i].x) index = i;
            } else if (op.equalsIgnoreCase("min")) {
                for (int i = 1; i < points.length; i++)
                    if (points[index].x > points[i].x) index = i;
            }
        } else if (axis.equalsIgnoreCase("y")) {
            if (op.equalsIgnoreCase("max")) {
                for (int i = 1; i < points.length; i++)
                    if (points[index].y < points[i].y) index = i;
            } else if (op.equalsIgnoreCase("min")) {
                for (int i = 1; i < points.length; i++) {
                    if (points[index].y > points[i].y) index = i;
                    if (points[index].y == points[i].y && points[index].x > points[i].x) index = i;
                }
            }
        }
        return index;
    }

    static Comparator polarOrderComparator() {
        return new PolarOrder();
    }
    private static class PolarOrder implements Comparator<Point> {
        @Override
        public int compare(Point p1, Point p2) {
            // For polar angle
            int orientation = orientation(point, p1, p2);
            // For collinear
            if (orientation == 0) return (distance(point, p2) >= distance(point, p1)) ? -1 : 1;
            return orientation;
        }
    }

    private static int distance(Point point, Point point1) {
        return (point.x - point1.x)*(point.x - point1.x) + (point.y - point1.y)*(point.y - point1.y);
    }
}
