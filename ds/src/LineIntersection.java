public class LineIntersection {
    public boolean checkIntersection(Point p1, Point q1, Point p2, Point q2) {
        int o1 = Point.orientation(p1, q1, p2);
        int o2 = Point.orientation(p1, q1, q2);
        int o3 = Point.orientation(p2, q2, p1);
        int o4 = Point.orientation(p2, q2, q1);

        if (o1 != o2 && o3 != o4) return true;

        if (o1 == 0 && Point.onSegment(p1, p2, q1)) return true;
        if (o2 == 0 && Point.onSegment(p1, q2, q1)) return true;
        if (o3 == 0 && Point.onSegment(p2, p1, q2)) return true;
        if (o4 == 0 && Point.onSegment(p2, q1, q2)) return true;
        return false;
    }

    public static void main(String[] args) {
        Point p1 = new Point(1, 1);
        Point q1 = new Point(10, 1);
        Point p2 = new Point(1, 2);
        Point q2 = new Point(10, 2);

        LineIntersection lineIntersection = new LineIntersection();
        System.out.println(lineIntersection.checkIntersection(p1, q1, p2, q2));
    }
}
