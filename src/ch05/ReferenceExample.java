package ch05;

/**
 * 좌표를 나타내는 클래스
 */
class Point {
    public int x;
    public int y;

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public void display() {
        System.out.println("좌표: (" + x + ", " + y + ")");
    }

    // 객체 복사를 위한 메서드
    public Point copy() {
        Point newPoint = new Point();
        newPoint.x = this.x;
        newPoint.y = this.y;
        return newPoint;
    }
}

// 참조 실험
public class ReferenceExample {
    public static void main(String[] args) {
        // 1. 참조 복사
        System.out.println("=== 참조 복사 ===");
        Point p1 = new Point();
        p1.setLocation(10, 20);

        Point p2 = p1;  // 참조 복사 (같은 객체를 가리킴)

        System.out.println("p1:");
        p1.display();
        System.out.println("p2:");
        p2.display();

        p2.move(5, 5);  // p2를 통해 이동

        System.out.println("\np2 이동 후:");
        System.out.println("p1:");
        p1.display();  // p1도 변경됨!
        System.out.println("p2:");
        p2.display();

        // 2. 객체 복사
        System.out.println("\n=== 객체 복사 ===");
        Point p3 = new Point();
        p3.setLocation(30, 40);

        Point p4 = p3.copy();  // 새로운 객체 생성

        System.out.println("p3:");
        p3.display();
        System.out.println("p4:");
        p4.display();

        p4.move(5, 5);  // p4만 이동

        System.out.println("\np4 이동 후:");
        System.out.println("p3:");
        p3.display();  // p3는 그대로
        System.out.println("p4:");
        p4.display();  // p4만 변경됨

        // 3. null 참조
        System.out.println("\n=== null 참조 ===");
        Point p5 = null;

        if (p5 == null) {
            System.out.println("p5는 null입니다.");
        }

        // 안전한 null 체크
        Point p6 = getPoint(false);
        if (p6 != null) {
            p6.display();
        } else {
            System.out.println("포인트가 생성되지 않았습니다.");
        }
    }

    // null을 반환할 수 있는 메서드
    public static Point getPoint(boolean create) {
        if (create) {
            Point p = new Point();
            p.setLocation(100, 100);
            return p;
        }
        return null;
    }
}