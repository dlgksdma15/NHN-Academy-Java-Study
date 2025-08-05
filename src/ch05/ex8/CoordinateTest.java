package ch05.ex8;

/**
 * 2D와 3D 좌표를 다루는 좌표 시스템
 */
class CoordinateSystem {

    // 2D 좌표를 나타내는 정적 중첩 클래스
    public static class Point2D {
        private double x, y;

        public Point2D(double x, double y) {
            // TODO 1: x와 y 좌표 초기화하기
            this.x = x;
            this.y = y;
        }

        public double distanceFromOrigin() {
            // TODO 2: 원점(0, 0)으로부터의 거리 계산하기
            // 피타고라스 정리 사용: sqrt(x² + y²)
            double sum = Math.pow(x, 2) + Math.pow(y, 2);
            return Math.sqrt(sum);
        }

        public double distanceTo(Point2D other) {
            // TODO 3: 다른 점까지의 거리 계산하기
            // 두 점 사이의 거리 공식 사용
            double result = x * (other.x - x) + y * (other.y - y);
            return Math.sqrt(result);
        }

        @Override
        public String toString() {
            // TODO 4: "(x, y)" 형식으로 좌표 반환하기
            // 소수점 2자리까지 표시
            return "(%.2f, %.2f)".formatted(x,y);
        }
    }

    // 3D 좌표를 나타내는 정적 중첩 클래스
    public static class Point3D {
        private double x, y, z;

        public Point3D(double x, double y, double z) {
            // TODO 5: x, y, z 좌표 초기화하기
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public double distanceFromOrigin() {
            // TODO 6: 3D 공간에서 원점으로부터의 거리 계산하기
            // sqrt(x² + y² + z²)
            return Math.sqrt(x * x + y + y + z + z);
        }

        public Point2D projectToXY() {
            // TODO 7: XY 평면으로 투영하기 (z 좌표 무시)
            return new Point2D(x,y);
        }

        public Point2D projectToXZ() {
            // TODO 8: XZ 평면으로 투영하기 (y 좌표 무시)
            return new Point2D(x,z);
        }

        public Point2D projectToYZ() {
            // TODO 9: YZ 평면으로 투영하기 (x 좌표 무시)
            return new Point2D(y,z);
        }

        @Override
        public String toString() {
            // TODO 10: "(x, y, z)" 형식으로 좌표 반환하기
            return "(%.2f,%.2f,%.2f)".formatted(x,y,z);
        }
    }

    // 선분을 나타내는 정적 중첩 클래스
    public static class LineSegment {
        private Point3D start;
        private Point3D end;

        public LineSegment(Point3D start, Point3D end) {
            // TODO 11: 시작점과 끝점 초기화하기
            this.start = start;
            this.end = end;
        }

        public double getLength() {
            // TODO 12: 선분의 길이 계산하기
            // 두 점 사이의 3D 거리 공식 사용
            double x = end.x - start.x;
            double y = end.y - start.y;
            double z = end.z - start.z;

            return Math.sqrt(x * x + y * y + z * z);
        }

        public Point3D getMidpoint() {
            // TODO 13: 선분의 중점 계산하기
            // 각 좌표의 평균값
            double x = start.x + end.x;
            double y = start.y + end.y;
            double z = start.z + end.z;

            return new Point3D(x / 2,y / 2,z / 2);
        }
    }
}

// 테스트 클래스
public class CoordinateTest {
    public static void main(String[] args) {
        // TODO 14: 2D 점 생성하기
        // p1: (3, 4), p2: (6, 8)
        CoordinateSystem.Point2D p1 = new CoordinateSystem.Point2D(3, 4);
        CoordinateSystem.Point2D p2 = new CoordinateSystem.Point2D(6,8);

        // TODO 15: 2D 점 정보 출력하기
        // p1, p2 출력
        // 원점에서 p1까지의 거리
        // p1에서 p2까지의 거리
        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2);
        System.out.println("원점에서 p1까지의 거리:" + p1.distanceFromOrigin());
        System.out.println("p1에서 p2까지의 거리: " + p1.distanceTo(p2));

        // TODO 16: 3D 점 생성하기
        // p3d1: (1, 2, 3), p3d2: (4, 5, 6)
        CoordinateSystem.Point3D p3d1 = new CoordinateSystem.Point3D(1,2,3);
        CoordinateSystem.Point3D p3d2= new CoordinateSystem.Point3D(4,5,6);

        // TODO 17: 3D 점 정보 출력하기
        // p3d1 출력
        // XY 평면으로의 투영 출력
        System.out.println("3D 점: P3D1: "+ p3d1);
        System.out.println("XY 평면 투영: " + p3d1.projectToXY());

        // TODO 18: 선분 생성하고 정보 출력하기
        // p3d1에서 p3d2로의 선분
        CoordinateSystem.LineSegment lineSegment = new CoordinateSystem.LineSegment(p3d1,p3d2);
        // 길이와 중점 출력
        double length = lineSegment.getLength();
        System.out.println("선분: 길이: " + length) ;
        String str = lineSegment.getMidpoint().toString();
        System.out.println(str);
    }
}

