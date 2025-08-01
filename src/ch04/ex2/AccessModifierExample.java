package ch04.ex2;

public class AccessModifierExample {
    // public - 어디서든 접근 가능 (이미 구현됨)
    public static void publicMethod() {
        System.out.println("Public 메서드 호출됨");
    }

    // TODO 15: private 메서드 구현하기
    private static void privateMethod() {
        System.out.println("Private 메서드 호출됨");
    }

    // TODO 16: package 메서드 구현하기
    static void packageMethod() {
        System.out.println("Package 메서드 호출됨");
    }

    public static void main(String[] args) {
        System.out.println("=== 접근 제어자 예제 ===\n");

        // TODO 17: 같은 클래스 내에서 모든 메서드 호출하기
        publicMethod();
        privateMethod();
        packageMethod();

        // TODO 18: private 메서드를 public 메서드를 통해 간접 호출하기
        usePrivateMethod();
        AccessTest.testAccess();
    }

    // TODO 19: private 메서드를 사용하는 public 메서드 구현하기
    public static void usePrivateMethod() {
        System.out.println("\npublic 메서드에서 private 메서드 호출:");
        privateMethod();
    }
}

// TODO 20: 다른 클래스에서 접근 테스트하기
class AccessTest {
    public static void testAccess() {
        // public 메서드는 접근 가능
        AccessModifierExample.publicMethod();

        // package 메서드는 같은 패키지라면 접근 가능
        AccessModifierExample.packageMethod();

        // private 메서드는 접근 불가 (주석으로 표시)
        //AccessModifierExample.privateMethod(); // 컴파일 오류!
    }
}