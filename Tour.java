public class Tour {
    public static class Point {
        private final double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double distanceTo(Point that) {
            double dx = this.x - that.x;
            double dy = this.y - that.y;
            return Math.sqrt(dx * dx + dy * dy);
        }

        public void draw() {
            StdDraw.point(x, y);
        }

        public void drawTo(Point that) {
            StdDraw.line(this.x, this.y, that.x, that.y);
        }

        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    private Node head;

    private class Node {
        private Point p;
        private Node next;

        public Node(Point p) {
            this.p = p;
        }
    }

    public Tour() {
        head = null;
    }

    public Tour(Point a, Point b, Point c, Point d) {
        head = new Node(a);
        Node bNode = new Node(b);
        Node cNode = new Node(c);
        Node dNode = new Node(d);
        head.next = bNode;
        bNode.next = cNode;
        cNode.next = dNode;
        dNode.next = head;
    }

    public int size() {
        if (head == null) return 0;
        int count = 1;
        Node current = head;
        while (current.next != head) {
            count++;
            current = current.next;
        }
        return count;
    }

    public double length() {
        if (head == null) return 0.0;
        double total = 0.0;
        Node current = head;
        do {
            total += current.p.distanceTo(current.next.p);
            current = current.next;
        } while (current != head);
        return total;
    }

    public String toString() {
        if (head == null) return "";
        StringBuilder sb = new StringBuilder();
        Node current = head;
        do {
            sb.append(current.p).append("\n");
            current = current.next;
        } while (current != head);
        return sb.toString();
    }

    public void draw() {
        if (head == null) return;
        Node current = head;
        do {
            current.p.drawTo(current.next.p);
            current = current.next;
        } while (current != head);
    }

    public void insertNearest(Point p) {
        if (head == null) {
            head = new Node(p);
            head.next = head;
            return;
        }

        Node nearest = head;
        double minDistance = Double.MAX_VALUE;

        Node current = head;
        do {
            double distance = current.p.distanceTo(p);
            if (distance < minDistance) {
                minDistance = distance;
                nearest = current;
            }
            current = current.next;
        } while (current != head);

        Node newNode = new Node(p);
        newNode.next = nearest.next;
        nearest.next = newNode;
    }

    public void insertSmallest(Point p) {
        if (head == null) {
            head = new Node(p);
            head.next = head;
            return;
        }

        Node bestPosition = head;
        double minIncrease = Double.MAX_VALUE;

        Node current = head;
        do {
            double increase = current.p.distanceTo(p) + p.distanceTo(current.next.p)
                    - current.p.distanceTo(current.next.p);
            if (increase < minIncrease) {
                minIncrease = increase;
                bestPosition = current;
            }
            current = current.next;
        } while (current != head);

        Node newNode = new Node(p);
        newNode.next = bestPosition.next;
        bestPosition.next = newNode;
    }

    public static void main(String[] args) {
        StdDraw.setXscale(0, 6);
        StdDraw.setYscale(0, 6);
        Point a = new Point(1.0, 1.0);
        Point b = new Point(1.0, 4.0);
        Point c = new Point(4.0, 4.0);
        Point d = new Point(4.0, 1.0);
        Tour tour = new Tour(a, b, c, d);
        System.out.println("Initial Tour: ");
        System.out.println(tour);
        System.out.println("Length: " + tour.length());
        System.out.println("Size: " + tour.size());
        Point e = new Point(5.0, 6.0);
        tour.insertNearest(e);
        System.out.println("\nAfter Nearest Neighbor Insertion:");
        System.out.println(tour);
        System.out.println("Tour Length: " + tour.length());
        tour.draw();
        Point f = new Point(2.0, 2.0);
        tour.insertSmallest(f);
        System.out.println("\nAfter Smallest Increase Insertion:");
        System.out.println(tour);
        System.out.println("Tour Length: " + tour.length());
        tour.draw();
    }
}


