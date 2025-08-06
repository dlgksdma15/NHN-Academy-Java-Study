package ch07.ex4;

public class BasicRecordExample {
    // 2D 좌표 Point 레코드
    record Point(int x, int y) { }

    // Rectangle 레코드: topLeft, bottomRight
    record Rectangle(Point topLeft, Point bottomRight) {
        // 너비 계산
        public int width() {
            return bottomRight.x() - topLeft.x();
        }
        // 높이 계산
        public int height() {
            return bottomRight.y() - topLeft.y();
        }
        // 면적 계산
        public int area() {
            return width() * height();
        }
    }

    public static void main(String[] args) {
        Point p1 = new Point(10, 20);
        Point p2 = new Point(50, 80);
        Rectangle rect = new Rectangle(p1, p2);

        System.out.println("점 1: x=" + p1.x() + ", y=" + p1.y());
        System.out.println("점 2: x=" + p2.x() + ", y=" + p2.y());
        System.out.println("점 1: " + p1);
        System.out.println("사각형: " + rect);
        System.out.println("사각형 너비: " + rect.width());
        System.out.println("사각형 높이: " + rect.height());
        System.out.println("사각형 면적: " + rect.area());

        Point p3 = new Point(10, 20);
        System.out.println("p1.equals(p3): " + p1.equals(p3));
        System.out.println("p1 == p3: " + (p1 == p3));
    }
}

