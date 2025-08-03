package ch04.ex5;

interface StringOperation {
    String apply(String s);
}

interface IntSupplier {
    int get();
}

class StringProcessor {
    private String prefix;

    StringProcessor(String prefix) {
        this.prefix = prefix;
    }

    String addPrefix(String s) {
        return prefix + s;
    }

    String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}

public class InstanceMethodReference {
    public static void main(String[] args) {
        System.out.println("=== 인스턴스 메서드 참조 ===\n");

        // TODO 49: String 인스턴스의 메서드 참조 사용하기
        String str = "Hello World";
        IntSupplier length = str::length;
        StringOperation toUpper = s -> str.toUpperCase();
        System.out.println("길이: " + length.get());
        System.out.println("대문자: " + toUpper.apply(""));

        // TODO 50: 사용자 정의 클래스의 인스턴스 메서드 참조 사용하기
        StringProcessor processor = new StringProcessor("[접두사] ");
        StringOperation addPre = processor::addPrefix;
        StringOperation rev = processor::reverse;
        System.out.println(addPre.apply("메시지"));
        System.out.println(rev.apply("Hello"));

        // TODO 51: 특정 타입의 임의 객체의 인스턴스 메서드 참조 사용하기
        StringOperation trim = String::trim;
        StringOperation lower = String::toLowerCase;
        System.out.println("trim: '" + trim.apply("  공백 제거  ") + "'");
        System.out.println("lower: " + lower.apply("HELLO"));
    }
}
