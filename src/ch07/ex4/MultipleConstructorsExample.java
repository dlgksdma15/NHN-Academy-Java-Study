package ch07.ex4;

public class MultipleConstructorsExample {
    record FullName(String firstName, String lastName) {
        public FullName(String singleName) {
            this(singleName, "");
        }
        public String displayName() {
            return lastName.isBlank() ? firstName : firstName + " " + lastName;
        }
        @Override
        public String toString() {
            return displayName();
        }
    }

    record Point(double x, double y) {}

    record Circle(double centerX, double centerY, double radius) {
        public Circle(double radius) {
            this(0, 0, radius);
        }
        public Circle(Point center, double radius) {
            this(center.x(), center.y(), radius);
        }
        public double area() {
            return Math.PI * radius * radius;
        }
    }

    public static void main(String[] args) {
        FullName name1 = new FullName("홍", "길동");
        FullName name2 = new FullName("Madonna");
        System.out.println("이름 1: " + name1);
        System.out.println("이름 2: " + name2);

        Circle circle1 = new Circle(5.0);
        Circle circle2 = new Circle(10, 10, 3.0);
        Circle circle3 = new Circle(new Point(20, 20), 4.0);
        System.out.println("\n원 1: " + circle1);
        System.out.println("원 2: " + circle2);
        System.out.println("원 3: " + circle3);
        System.out.printf("원 1 면적: %.2f\n", circle1.area());
    }
}
